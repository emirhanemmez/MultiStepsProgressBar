package com.emirhanemmez.multiplestepsprogressbarlib

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.emirhanemmez.multistepsprogressbar.model.ProgressProperties
import com.emirhanemmez.multistepsprogressbar.model.StepData
import com.emirhanemmez.multistepsprogressbar.model.StepId
import com.emirhanemmez.multistepsprogressbar.updateStepProgress
import kotlin.random.Random

class MainViewModel : ViewModel() {

    private val _stepList = mutableStateListOf<StepData>().apply {
        addAll(
            listOf(
                StepData(
                    stepId = Id.FirstStep,
                    stepName = "Step1",
                    progress = ProgressProperties.PROGRESS_FULL
                ),
                StepData(
                    stepId = Id.SecondStep,
                    stepName = "Step2",
                    progress = ProgressProperties.PROGRESS_NONE,
                ),
                StepData(
                    stepId = Id.ThirdStep,
                    stepName = "Step3",
                    progress = ProgressProperties.PROGRESS_HALF
                )
            )
        )
    }
    val stepList: List<StepData> = _stepList

    fun updateProgressesWithRandomValues() {
        _stepList.updateStepProgress(Id.FirstStep, Random.nextFloat())
        _stepList.updateStepProgress(Id.SecondStep, Random.nextFloat())
        _stepList.updateStepProgress(Id.ThirdStep, Random.nextFloat())
    }

    sealed class Id(id: Int) : StepId(id) {
        data object FirstStep : Id(0)
        data object SecondStep : Id(1)
        data object ThirdStep : Id(2)
    }
}