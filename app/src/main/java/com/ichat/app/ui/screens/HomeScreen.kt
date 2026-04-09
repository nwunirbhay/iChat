package com.ichat.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ichat.app.ui.components.ChatRow
import com.ichat.app.viewmodel.HomeViewModel

@Composable
fun HomeScreen(vm: HomeViewModel = viewModel()) {
    val conversations by vm.conversations.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("iChat") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            Text(
                text = "Chats",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
            )
            LazyColumn(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                items(conversations, key = { it.id }) { conversation ->
                    ChatRow(conversation = conversation, onTap = { })
                }
            }
        }
    }
}
