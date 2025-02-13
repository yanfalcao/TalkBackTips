package com.yanfalcao.talkbacktips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yanfalcao.talkbacktips.ui.theme.TalkBackTipsTheme
import com.yanfalcao.talkbacktips.widget.DefaultTopAppBar

class GroupingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TalkBackTipsTheme {
                BodyGrouping()
            }
        }
    }
}

@Composable
fun BodyGrouping() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DefaultTopAppBar(stringResource(R.string.grouping_tip))
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.ungrouped_title),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 25.dp),
                )

                UngroupedExample()

                Text(
                    text = stringResource(R.string.grouped_title),
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(top = 45.dp ,bottom = 25.dp),
                    textAlign = TextAlign.Center
                )

                GroupedExample()
            }
        }
    }
}

@Composable
fun UngroupedExample() {
    Column(
        modifier =
        Modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(size = 15.dp),
            )
            .semantics(mergeDescendants = true) {}
            .padding(horizontal = 15.dp, vertical = 15.dp)
            .fillMaxWidth(),
    ) {
        Text(
            text = stringResource(R.string.recipe_name_example),
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.titleLarge,
        )

        Text(
            text = stringResource(R.string.recipe_prep_time_example),
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 12.dp),
        )

        Text(
            text = stringResource(R.string.recipe_servings_example),
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp),
        )
    }
}

@Composable
fun GroupedExample() {
    Column(
        modifier =
        Modifier
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(size = 15.dp),
            )
            .padding(horizontal = 15.dp, vertical = 15.dp)
            .fillMaxWidth()
            .semantics(mergeDescendants = true) {},
    ) {
        Text(
            text = stringResource(R.string.recipe_name_example),
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.titleLarge,
        )

        Text(
            text = stringResource(R.string.recipe_prep_time_example),
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 12.dp),
        )

        Text(
            text = stringResource(R.string.recipe_servings_example),
            color = MaterialTheme.colorScheme.background,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 8.dp),
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GroupingPreview() {
    TalkBackTipsTheme {
        BodyGrouping()
    }
}