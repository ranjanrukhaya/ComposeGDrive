package com.grace.composegdrive.data

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.grace.composegdrive.R
import com.grace.composegdrive.ui.theme.*

@Immutable
data class FolderData(
    val folderName: String,
    val folderDate: String,
    val folderIcon: Int,
    val folderOption: Int,
    val folderBackground: Color,
    val folderTitleColor: Color,
    val folderSubTitleColor: Color
)

/**
 * A fake repo returning list of puppies
 */
object FolderRepo {
    fun getFoldersData(): List<FolderData> = folders
}

private val folder1 = FolderData(
    folderName = "Web Design",
    folderDate = "20 Dec 2020",
    folderIcon = R.drawable.folder_blue,
    folderOption = R.drawable.option_blue,
    folderBackground = BlueBackground,
    folderTitleColor = BlueTitleColor,
    folderSubTitleColor = BlueSubTitleColor
)

private val folders = listOf(
    folder1,
    folder1.copy(
        folderName = "App Design",
        folderDate = "21 Dec 2020",
        folderIcon = R.drawable.folder_yellow,
        folderOption = R.drawable.option_yellow,
        folderBackground = YellowBackground,
        folderTitleColor = BlueTitleColor,
        folderSubTitleColor = BlueSubTitleColor
    ),
    folder1.copy(
        folderName = "Font Design",
        folderDate = "22 Dec 2020",
        folderIcon = R.drawable.folder_red,
        folderOption = R.drawable.option_red,
        folderBackground = RedBackground,
        folderTitleColor = RedTitleColor,
        folderSubTitleColor = RedSubTitleColor
    ),
    folder1.copy(
        folderName = "Illustrations",
        folderDate = "23 Dec 2020",
        folderIcon = R.drawable.folder_green,
        folderOption = R.drawable.option_green,
        folderBackground = GreenBackground,
        folderTitleColor = GreenTitleColor,
        folderSubTitleColor = GreenSubTitleColor
    ),
    folder1,
    folder1.copy(
        folderName = "App Design",
        folderDate = "21 Dec 2020",
        folderIcon = R.drawable.folder_yellow,
        folderOption = R.drawable.option_yellow,
        folderBackground = YellowBackground,
        folderTitleColor = BlueTitleColor,
        folderSubTitleColor = BlueSubTitleColor
    ),
    folder1.copy(
        folderName = "Font Design",
        folderDate = "22 Dec 2020",
        folderIcon = R.drawable.folder_red,
        folderOption = R.drawable.option_red,
        folderBackground = RedBackground,
        folderTitleColor = RedTitleColor,
        folderSubTitleColor = RedSubTitleColor
    ),
    folder1.copy(
        folderName = "Illustrations",
        folderDate = "23 Dec 2020",
        folderIcon = R.drawable.folder_green,
        folderOption = R.drawable.option_green,
        folderBackground = GreenBackground,
        folderTitleColor = GreenTitleColor,
        folderSubTitleColor = GreenSubTitleColor
    )
)
