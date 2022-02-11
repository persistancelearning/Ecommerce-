package com.onebox.ecommerce.cartapi.job;

import com.onebox.ecommerce.cartapi.service.CartService;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TimeToLiveJob implements Job {

	@Autowired
	public CartService cartService;

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		cartService.deleteCartOverTimeToLive();		
	}

}

