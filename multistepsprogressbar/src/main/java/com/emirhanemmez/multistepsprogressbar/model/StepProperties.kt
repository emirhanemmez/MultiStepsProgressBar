package com.emirhanemmez.multistepsprogressbar.model

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.spring
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.emirhanemmez.multistepsprogressbar.defaultActiveTextColor
import com.emirhanemmez.multistepsprogressbar.defaultInactiveTextColor
import com.emirhanemmez.multistepsprogressbar.defaultIndicatorHeight
import com.emirhanemmez.multistepsprogressbar.defaultProgressBackgroundColor
import com.emirhanemmez.multistepsprogressbar.defaultProgressColor

data class StepProperties(
    val progressProperties: ProgressProperties = ProgressProperties.default(),
    val indicatorHeight: Dp = defaultIndicatorHeight,
    val textProperties: TextProperties,
    val marginBetweenSteps: Dp = 16.dp,
    val marginBetweenTextAndProgress: Dp = 16.dp,
    val animationSpec: AnimationSpec<Float> = spring()
)

data class TextProperties(
    val textStyle: TextStyle,
    val activeTextColor: Color,
    val inActiveTextColor: Color,
    val textAlign: TextAlign
) {
    companion object {
        @Composable
        fun default(): TextProperties =
            TextProperties(
                textStyle = MaterialTheme.typography.bodySmall,
                activeTextColor = defaultActiveTextColor,
                inActiveTextColor = defaultInactiveTextColor,
                textAlign = TextAlign.Start
            )
    }
}

data class ProgressProperties(
    val progressColor: Color,
    val progressBackgroundColor: Color,
    val progressCornerRadius: Dp,
) {
    companion object {
        const val PROGRESS_NONE = 0f
        const val PROGRESS_HALF = 0.5f
        const val PROGRESS_FULL = 1f

        fun default(): ProgressProperties =
            ProgressProperties(
                progressColor = defaultProgressColor,
                progressBackgroundColor = defaultProgressBackgroundColor,
                progressCornerRadius = 16.dp,
            )
    }
}