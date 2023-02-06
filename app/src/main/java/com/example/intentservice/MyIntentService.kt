package com.example.intentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService() : IntentService("MyIntentService") {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false

        fun stopService() {
            Log.d("MyIntentService", "Service is stopping...")
            isRunning = false
            instance.stopSelf() // stops this instance service.
        }
    }

    // Cada IntentService precisa implementar essa função, que é usada pra processar as intents que
    // passamos para o serviço quando o iniciamos. Então quando iniciamos um serviço, nós criamos
    // uma intent pra isso (como para start uma activity). Podemos chamar essa Intent Service
    // novamente depois e passar uma intent diferente. Pra cada intent, essa função será chamada,
    // e essa classe MyIntentService vai processar uma Intent por vez. Se vc passar várias intents,
    // o sistema vai lidar com uma intent por vez. Nesse exemplo ela só vai lidar com uma Intent simples.
    override fun onHandleIntent(p0: Intent?) {
        try {
            isRunning = true
            while (isRunning) {
                Log.d("MyIntentService", "Service is running...")
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt() // Apenas interrompemos a thread atual.
        }
    }
}
