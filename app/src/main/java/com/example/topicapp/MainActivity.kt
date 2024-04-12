package com.example.topicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.topicapp.data.DataSource
import com.example.topicapp.model.Topic
import com.example.topicapp.ui.theme.TopicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopicAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    //TopicCard(Topic(R.string.architecture,30,R.drawable.architecture))
                    TopicApp()
                }
            }
        }
    }
}

@Composable
fun TopicApp() {
        TopicList(topicList = DataSource.topics)
}

@Composable
fun TopicCard(topic : Topic, modifier: Modifier = Modifier) {

    Card {

        Row {
            Image(
                painter = painterResource(id = topic.imageResource) ,
                contentDescription = null,
                modifier = Modifier
                    .weight(1f)
                    .height(68.dp)
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(id = topic.name),
                modifier = Modifier
                    .weight(2f)
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 8.dp
                    ),
                style = MaterialTheme.typography.bodyMedium,

            )
        }
    }
}

@Composable
fun TopicList(topicList : List<Topic>, modifier : Modifier = Modifier){
    LazyVerticalGrid(modifier = modifier.padding(8.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(topicList){topic ->
                TopicCard(topic = topic)

            }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopicAppTheme {
        //TopicCard(Topic(R.string.architecture,30,R.drawable.architecture))
        TopicApp()
    }
}