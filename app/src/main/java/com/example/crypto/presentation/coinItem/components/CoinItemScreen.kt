package com.example.crypto.presentation.coinItem.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.crypto.domain.model.CoinItem


@Composable
fun CoinItemScreen(
    coinItem: CoinItem,
   onItemClick : (CoinItem) -> Unit
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coinItem) }
            .padding(15.dp)
    ) {
        Text(
            text = "${coinItem.rank}. ${coinItem.name} ${coinItem.symbol}",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text =if(coinItem.is_active) "isActive" else "inActive",
            color= if(coinItem.is_active) Color.Green else Color.Red,
            textAlign = TextAlign.End,
            modifier = Modifier.align(CenterVertically)
        )



    }

}