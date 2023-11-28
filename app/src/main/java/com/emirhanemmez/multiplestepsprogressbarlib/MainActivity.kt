package com.emirhanemmez.multiplestepsprogressbarlib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.emirhanemmez.multiplestepsprogressbarlib.ui.theme.MyTheme
import com.emirhanemmez.multistepsprogressbar.MultipleStepsProgressBar

class MainActivity : ComponentActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(56.dp))

                        MultipleStepsProgressBar(
                            stepDataList = mainViewModel.stepList
                        )

                        Spacer(modifier = Modifier.height(56.dp))

                        Button(onClick = {
                            mainViewModel.updateProgressesWithRandomValues()
                        }) {
                            Text(text = "Click for random progresses")
                        }
                    }
                }
            }
        }
    }
}
