package com.example.task2v2.cqrs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class CQRSRegistry {

    private Map<Class<? extends Command<?>>, CommandProvider<?>> commandProviderMap = new HashMap<>();

    @Autowired
    public CQRSRegistry(ApplicationContext applicationContext){

        String[] names = applicationContext.getBeanNamesForType(CommandHandler.class);

        for (String name: names){
            registerCommand(applicationContext, name);
            log.info("Handler {} is registered", name);
        }
    }

    public void registerCommand(ApplicationContext context, String name){
        Class<CommandHandler<?,?>> handlerClass = (Class<CommandHandler<?,?>>) context.getType(name);
        Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(handlerClass, CommandHandler.class);
        Class<? extends Command<?>> commandType = (Class<? extends Command<?>>) generics[1];
        commandProviderMap.put(commandType, new CommandProvider(context, handlerClass));
    }

    @SuppressWarnings("unchecked")
    public <R, C extends Command<R>> CommandHandler<R, C> getCommandHandler(Class<C> commandClass){
        return (CommandHandler<R, C>) commandProviderMap.get(commandClass).get();
    }
}
