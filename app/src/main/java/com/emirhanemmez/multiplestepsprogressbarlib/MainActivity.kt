package com.emirhanemmez.multiplestepsprogressbarlib

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.emirhanemmez.multistepsprogressbar.MultipleStepsProgressBar
import com.emirhanemmez.multistepsprogressbar.model.StepData
import com.emirhanemmez.multistepsprogressbar.model.StepId
import com.emirhanemmez.multistepsprogressbar.model.StepProperties
import com.emirhanemmez.multiplestepsprogressbarlib.ui.theme.MultipleStepsProgressBarLibTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultipleStepsProgressBarLibTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MultipleStepsProgressBar(
                        stepDataList = listOf(
                            StepData(
                                stepId = StepId(0),
                                stepName = "Step1",
                                progress = StepProperties.PROGRESS_FULL
                            ),
                            StepData(
                                stepId = StepId(1),
                                stepName = "Step2",
                                progress = StepProperties.PROGRESS_NONE,
                            ),
                            StepData(
                                stepId = StepId(2),
                                stepName = "Step3",
                                progress = StepProperties.PROGRESS_HALF
                            )
                        )
                    )
                }
            }
        }
    }
}
