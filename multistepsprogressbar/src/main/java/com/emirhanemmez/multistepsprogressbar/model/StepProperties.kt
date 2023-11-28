package com.emirhanemmez.multistepsprogressbar.model

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.emirhanemmez.multistepsprogressbar.defaultActiveTextColor
import com.emirhanemmez.multistepsprogressbar.defaultInactiveTextColor
import com.emirhanemmez.multistepsprogressbar.defaultIndicatorHeight
import com.emirhanemmez.multistepsprogressbar.defaultProgressBackgroundColor
import com.emirhanemmez.multistepsprogressbar.defaultProgressColor

data class StepProperties(
    val progressProperties: ProgressProperties,
    val indicatorHeight: Dp,
    val textProperties: TextProperties,
    val marginBetweenSteps: Dp,
    val marginBetweenTextAndProgress: Dp
) {
    companion object {
        @Composable
        fun getDefault() = StepProperties(
            progressProperties = ProgressProperties(
                progressColor = defaultProgressColor,
                progressBackgroundColor = defaultProgressBackgroundColor,
                progressCornerRadius = 16.dp,
            ),
            indicatorHeight = defaultIndicatorHeight,
            textProperties = TextProperties(
                textStyle = MaterialTheme.typography.bodySmall,
                activeTextColor = defaultActiveTextColor,
                inActiveTextColor = defaultInactiveTextColor,
            ),
            marginBetweenSteps = 16.dp,
            marginBetweenTextAndProgress = 8.dp
        )
    }
}

data class TextProperties(
    val textStyle: TextStyle,
    val activeTextColor: Color,
    val inActiveTextColor: Color
)

data class ProgressProperties(
    val progressColor: Color,
    val progressBackgroundColor: Color,
    val progressCornerRadius: Dp,
) {
    companion object {
        const val PROGRESS_NONE = 0f
        const val PROGRESS_HALF = 0.5f
        const val PROGRESS_FULL = 1f
    }
}