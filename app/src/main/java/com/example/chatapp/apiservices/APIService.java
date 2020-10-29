package com.example.chatapp.apiservices;

import com.example.chatapp.notifications.MyResponse;
import com.example.chatapp.notifications.Sender;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {
    @Headers(
            {
                    "Content-Type:application/json",
                    "Authorization:key=AAAA_f7ZdmA:APA91bEqPV9_IIaxAlqPcljzcU8XtVfo8qDHLCqlYRpSQc0xVUFn5NBZinP0Rsm3fXNewdo3Qtjz6UKbDYrxKQBfYlq1w4_3mkbf7eKXnAHuyTC8BY0vWtJ5FnhvLulsoyjbTT6NGe8A"
            }
    )

    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body Sender body );
}
