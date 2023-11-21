package com.emirhanemmez.multistepsprogressbar.model

data class StepData(
    val stepId: StepId,
    val stepName: String,
    val progress: Float
)

open class StepId(
    open val index: Int
)