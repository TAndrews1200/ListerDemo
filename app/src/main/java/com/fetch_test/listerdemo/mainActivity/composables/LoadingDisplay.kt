package com.fetch_test.listerdemo.mainActivity.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.fetch_test.listerdemo.R
import com.fetch_test.listerdemo.ui.theme.BlackDarker
import com.fetch_test.listerdemo.ui.theme.BlackStandard

/**
 * A fullscreen display to show we're currently fetching the list
 *  @param modifier The modifier to be applied to the layout.
 */
@Composable
fun LoadingDisplay(modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(dimensionResource(R.dimen.spinner_size))
                .align(Alignment.Center),
            color = BlackDarker,
            strokeWidth = dimensionResource(R.dimen.spinner_stroke_width)
        )
    }
}

@Composable
@Preview
//Animated composable, please use the animation preview to properly check
private fun LoadingDisplayPreview(){
    LoadingDisplay(modifier = Modifier
        .fillMaxSize()
        .background(color = BlackStandard))
}