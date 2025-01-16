package com.fetch_test.listerdemo.mainActivity.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fetch_test.listerdemo.R
import com.fetch_test.listerdemo.mainActivity.MainViewModel
import com.fetch_test.listerdemo.retrofit.models.Name
import com.fetch_test.listerdemo.ui.theme.BlackDarker
import com.fetch_test.listerdemo.ui.theme.BlackLighter
import com.fetch_test.listerdemo.ui.theme.BlackStandard
import com.fetch_test.listerdemo.ui.theme.ListerDemoTheme

/**
 * A list to display the name entries. Shows simple text view if list is empty
 *  @param viewModel The MainViewModel backing the UI
 *  @param modifier The modifier to be applied to the layout.
 */
@Composable
fun NameList(viewModel: MainViewModel, modifier: Modifier) {
    val nameList = viewModel.nameList.observeAsState()
    NameListCore(nameList.value ?: listOf(), modifier)
}

/**
 * The core of the list, using the nameList rather than a specific viewModel
 *  @param nameList the actual list of names
 *  @param modifier The modifier to be applied to the layout.
 */
@Composable
private fun NameListCore(
    nameList: List<Name>,
    modifier: Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(dimensionResource(R.dimen.margin_4))
    ) {
        if (nameList.isEmpty()) {
            item {
                Box(
                    modifier = Modifier
                        .fillParentMaxSize()
                        .background(color = BlackLighter)
                ) {
                    Text(
                        text = stringResource(R.string.empty_list),
                        color = BlackDarker,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
        items(nameList.size) { index ->
            NamePlate(
                nameList[index], Modifier
                    .padding(dimensionResource(R.dimen.margin_2))
                    .background(
                        BlackStandard,
                        RoundedCornerShape(dimensionResource(R.dimen.plate_rounding))
                    )
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.margin_4))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NameListCorePreview() {
    val previewNameList = listOf(
        Name(1, 101, "Isca"),
        Name(1, 102, "Helshark"),
        Name(2, 201, "Adamine"),
        Name(2, 201, "Lethia"),
        Name(3, 354, "Hendrick"),
        Name(3, 392, "Cross"),
        Name(4, 422, "Amber"),
        Name(4, 495, "Rosia"),
    )
    ListerDemoTheme {
        NameListCore(
            previewNameList, modifier = Modifier
                .padding(PaddingValues(0.dp))
                .fillMaxSize()
        )
    }
}