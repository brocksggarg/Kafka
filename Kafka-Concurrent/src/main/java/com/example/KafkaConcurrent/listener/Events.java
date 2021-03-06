/*
 * PEARSON PROPRIETARY AND CONFIDENTIAL INFORMATION SUBJECT TO NDA 
 * Copyright (c) 2018 Pearson Education, Inc.
 * All Rights Reserved. 
 * 
 * NOTICE: All information contained herein is, and remains the property of 
 * Pearson Education, Inc. The intellectual and technical concepts contained 
 * herein are proprietary to Pearson Education, Inc. and may be covered by U.S. 
 * and Foreign Patents, patent applications, and are protected by trade secret 
 * or copyright law. Dissemination of this information, reproduction of this  
 * material, and copying or distribution of this software is strictly forbidden   
 * unless prior written permission is obtained from Pearson Education, Inc.
 */
package com.example.KafkaConcurrent.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * The Interface Events.
 */
public interface Events {
  String STATE_CHANGE_TOPIC = "Shubham";
  String SHUBHAM_OUT = "shubhamout";
  //String SHUBHAM_OUT2 = "shubhamout2";

  @Input(STATE_CHANGE_TOPIC)
  SubscribableChannel stateChangeTopicChannel();
  
  @Output(SHUBHAM_OUT)
  MessageChannel outputChannel();

  //@Output(SHUBHAM_OUT2)
  //MessageChannel outputChannel2();

}
