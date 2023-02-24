package com.example.crypto.presentation.coinDetil.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crypto.data.remote.dto.Team

@Composable
fun CoinTeam(teamMember : Team,modifier: Modifier = Modifier){

    Column(
       verticalArrangement = Arrangement.Center,
        modifier = modifier

    ){
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.body1
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.body2,
            fontStyle = FontStyle.Italic
        )

    }

}