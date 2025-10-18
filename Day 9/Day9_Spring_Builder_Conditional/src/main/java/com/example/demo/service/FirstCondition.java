package com.example.demo.service;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

import com.example.demo.Master;

@Component
@Order(2)
//@DependsOn("master")
//@Lazy
public class FirstCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//		context.getBeanFactory().getBeanDefinitionNames()FirstCondition
		System.out.println(context.getBeanFactory().containsBean("master"));
		 return context.getBeanFactory() != null &&
	               context.getBeanFactory().containsBeanDefinition("master");
//		return true;
	}

}
