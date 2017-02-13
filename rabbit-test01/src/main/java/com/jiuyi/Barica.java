package com.jiuyi;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Barica {

    String INPUT_CHANNEL = "input_channel";  //position3
    String OUTPUT_CHANNEL = "output_channel";

    String INPUT1 = "input1";
    String OUTPUT1 = "output1";
    // 注解@Input声明了它是一个输入类型的通道，名字是Barista.INPUT_CHANNEL，也就是position3的input_channel。
    // 这一名字与上述配置app2的配置文件中position1应该一致，表明注入了一个名字叫做input_channel的通道，它的类型是input，订阅的主题是position2处声明的mydest这个主题

    @Input(Barica.INPUT_CHANNEL)
    SubscribableChannel logInput();
    // 注解@Output声明了它是一个输出类型的通道，名字是output_channel。
    // 这一名字与app1中通道名一致，表明注入了一个名字为output_channel的通道，类型是output，发布的主题名为mydest。
    @Output(Barica.OUTPUT_CHANNEL)
    MessageChannel logOutPut();

    @Input(Barica.INPUT1)
    SubscribableChannel input1();

    @Output(Barica.OUTPUT1)
    MessageChannel output1();

}
