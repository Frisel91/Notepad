package com.frisel.registry.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.frisel.registry.db.User

@Composable
fun ListItem(
    item: User
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
            , verticalAlignment = Alignment.CenterVertically
        ) {
                Text(
                    item.firstName.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(5.dp)
                )
            Text(item.lastName,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(5.dp))
        }
    }
}