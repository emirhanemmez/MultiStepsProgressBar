package com.emirhanemmez.multistepsprogressbar

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.emirhanemmez.multistepsprogressbar.model.StepData
import com.emirhanemmez.multistepsprogressbar.model.StepId

fun SnapshotStateList<StepData>.updateStepProgress(stepId: StepId, progress: Float) {
    val index = stepId.index
    val step = this[index]
    this[index] = step.copy(progress = progress)
}