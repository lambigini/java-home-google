package com.sample.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class RetryListner implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation arg0, Class arg1, Constructor arg2,
			Method arg3) {
		// TODO Auto-generated method stub
		
		IRetryAnalyzer analyzer = arg0.getRetryAnalyzer();
		
		if (analyzer == null)	{
			arg0.setRetryAnalyzer(Retry.class);
		}

	}

}
