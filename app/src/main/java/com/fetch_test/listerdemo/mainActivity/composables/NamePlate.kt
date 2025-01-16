package com.fetch_test.listerdemo.mainActivity.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.fetch_test.listerdemo.R
import com.fetch_test.listerdemo.retrofit.models.Name
import com.fetch_test.listerdemo.ui.theme.BlackDarker
import com.fetch_test.listerdemo.ui.theme.BlackLighter
import com.fetch_test.listerdemo.ui.theme.BlackStandard
import com.fetch_test.listerdemo.ui.theme.ListerDemoTheme

/**
 * A simple layout for Name models, showing the listId, Id, and name
 *  @param name  The name model to be displayed
 *  @param modifier The modifier to be applied to the layout.
 */
@Composable
fun NamePlate(name: Name, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .size(dimensionResource(R.dimen.plate_label_size))
                .background(
                    BlackLighter,
                    RoundedCornerShape(dimensionResource(R.dimen.plate_rounding))
                ),
        ) {
            Text(
                text = name.listId.toString(),
                color = BlackStandard,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            modifier = Modifier
                .padding(start = dimensionResource(R.dimen.margin_6))
                .fillMaxWidth()
        ) {
            Text(
                fontWeight = FontWeight.Bold,
                text = "${name.id}",
            )
            Box(
                modifier = Modifier
                    .background(BlackDarker, RoundedCornerShape(dimensionResource(R.dimen.plate_rounding)))
            ) {

                Text(
                    color = BlackStandard,
                    //Empty name should never show
                    text = name.name ?: stringResource(R.string.empty_name),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(horizontal = dimensionResource(R.dimen.margin_6))
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NamePlatePreview() {
    val name = Name(4, 1854, "Cardinal")
    ListerDemoTheme {
        NamePlate(name, Modifier
            .padding(dimensionResource(R.dimen.margin_2))
            .background(
                BlackStandard,
                RoundedCornerShape(dimensionResource(R.dimen.plate_rounding))
            )
            .fillMaxWidth()
            .padding(dimensionResource(R.dimen.margin_4)))
    }
}