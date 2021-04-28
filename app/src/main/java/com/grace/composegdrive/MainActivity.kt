package com.grace.composegdrive

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.grace.composegdrive.data.FolderData
import com.grace.composegdrive.data.FolderRepo
import com.grace.composegdrive.ui.theme.*
import java.util.*

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val folders = remember { FolderRepo.getFoldersData() }
            ComposeGDriveTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Gray) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        Header()
                        Spacer(modifier = Modifier.height(8.dp))
                        SearchBar()
                        StorageCard()
                        FoldersView(folders)
                    }

                }
            }
        }
    }
}

@Composable
fun FolderCard(
    folder: FolderData,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .width(165.dp)
            .height(140.dp)
            .padding(top = 8.dp),
        shape = RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp),
    ) {
        Box(
            modifier = Modifier
                .background(folder.folderBackground)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = folder.folderIcon),
                        contentDescription = null
                    )
                    Image(
                        painter = painterResource(id = folder.folderOption),
                        contentDescription = null
                    )
                }
                Text(
                    text = folder.folderName,
                    color = folder.folderTitleColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 12.dp)
                )
                Text(text = folder.folderDate, color = folder.folderSubTitleColor)
            }
        }

    }
}

@ExperimentalFoundationApi
@Composable
fun FoldersView(folders: List<FolderData>) {
    Card(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp)
    ) {
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp)
                .background(Color.White)
        ) {
            Row(
                Modifier
                    .height(60.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "My Folders",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )

                Icon(painter = painterResource(id = R.drawable.sq_menu), contentDescription = null)
            }

            LazyVerticalGrid(
                cells = GridCells.Fixed(2)
            ) {
                items(folders) { item ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        FolderCard(folder = item)
                    }
                }
            }

            /*LazyColumn() {
                items(folders) { item ->
                    FolderCard(folder = item)
                }
            }*/

        }


    }
}

@Composable
fun StorageCard() {
    Card(
        shape = RoundedCornerShape(size = 16.dp),
        modifier = Modifier
            .padding(16.dp)
            .height(160.dp)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.background(BlueBox)) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Card(
                    shape = RoundedCornerShape(size = 12.dp),
                    modifier = Modifier
                        .padding(start = 32.dp, top = 42.dp)
                        .height(72.dp)
                        .width(72.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.drive),
                            contentDescription = null
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(start = 4.dp, top = 48.dp)
                ) {
                    Text(
                        text = "Free Storage",
                        style = TextStyle(color = Color.White, fontSize = 20.sp)
                    )

                    Text(
                        text = "7.5 GB / 15 GB",
                        style = TextStyle(color = Color.White, fontSize = 18.sp)
                    )
                }


                Card(
                    shape = RoundedCornerShape(0.dp, 12.dp, 0.dp, 12.dp),
                    modifier = Modifier
                        .height(54.dp)
                        .width(54.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .background(BlueBoxDark)
                            .padding(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.left),
                            contentDescription = null
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun SearchBar() {
    Card(
        shape = RoundedCornerShape(size = 16.dp),
        modifier = Modifier
            .padding(16.dp)
            .height(60.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.search), contentDescription = null)
            Text(text = "Search Files", modifier = Modifier.padding(start = 20.dp))
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.menu_new),
            contentDescription = null,
            modifier = Modifier.padding(start = 16.dp)
        )
        Text(
            text = "My Drive",
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Normal
        )
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = null,
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGDriveTheme {
        Greeting("Android")
    }
}