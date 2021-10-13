package com.barteklipinski.issuecomposepainterresource

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun Screen() {
    var showMasked: Boolean by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(1500L)
            showMasked = !showMasked //toggle Boolean value
        }
    }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row() {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Issue")
                PainterResourceIssue(showMasked)
            }
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Expected")
                PainterResourceIssueWorkaround(showMasked)
            }
        }
    }
}

@Composable
fun PainterResourceIssue(showMasked: Boolean) {
    val id = if (showMasked) {
        R.drawable.ic_bb_masked
    } else {
        R.drawable.ic_bb
    }
    Image(
        painter = painterResource(id),
        contentDescription = null
    )
}

@Composable
fun PainterResourceIssueWorkaround(showMasked: Boolean) {
    val id = if (showMasked) {
        R.drawable.ic_bb_masked
    } else {
        R.drawable.ic_bb
    }
    Image(
        painter = key(id) { painterResource(id) },
        contentDescription = null
    )
}