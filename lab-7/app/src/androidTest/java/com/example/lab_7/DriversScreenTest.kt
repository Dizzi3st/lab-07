package com.example.lab_7

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performScrollToIndex
import androidx.compose.ui.test.performScrollToNode
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class DriversScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity
    @Test
    fun navigate_to_drivers_add_driver_clear_drivers_and_return_home(){

        composeTestRule // test button click to move to drivers screen
            .onNodeWithTag("driverButton")
            .performClick()

        composeTestRule // check if on drivers screen
            .onNodeWithText("Drivers")
            .assertExists()

        composeTestRule // perform text input on name input
            .onNodeWithTag("nameInput")
            .performTextInput("Max Verstappen")

        composeTestRule // perform click on add driver button
            .onNodeWithTag("addDriverButton")
            .performClick()

        composeTestRule // check that the driver was added correctly
            .onNodeWithText("Max Verstappen")
            .assertExists()

        composeTestRule // perform click on the clear button
            .onNodeWithTag("clearButton")
            .performClick()

        composeTestRule // check that the added element no longer exists
            .onNodeWithText("Max Verstappen")
            .assertDoesNotExist()

        composeTestRule // perform click of the back button to return home
            .onNodeWithTag("backButton")
            .performClick()

        composeTestRule // check if at home screen
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}