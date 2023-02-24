package com.example.crypto.presentation.coinDetil.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.crypto.presentation.coinDetil.CoinDetailState
import com.example.crypto.presentation.coinDetil.CoinDetailViewModel
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetailScreen(

    viewModel : CoinDetailViewModel = hiltViewModel()
){
//    id?.let {
//        viewModel.getCoinDetail(id)
//    }
    val state = viewModel.state.value

    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        state.coin?.let { coin->

            LazyColumn(
                contentPadding = PaddingValues(20.dp),
                modifier = Modifier
                    .fillMaxSize()

            ){

                item {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()

                    ) {

                        Text(
                            text = "${coin.rank}. ${coin.name} ${coin.symbol}",
                            fontSize = 24.sp,
                            modifier = Modifier
                                .weight(8f)
                        )

                        Text(
                            text = if(coin.is_active) "isActive" else "inActive",
                            color = if(coin.is_active) Color.Green else Color.Red,
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)

                        )

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.h4
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                    FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags.forEach {tag ->
                        CoinTag(tag = tag)
                        }

                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Text(
                        text = "Team Members",
                        style = MaterialTheme.typography.h4
                    )
                    Spacer(modifier = Modifier.height(15.dp))

                }
                
                items(coin.team){teamMember->
                    CoinTeam(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)

                    )
                    Divider()
                    
                }




            }




        }
        if(state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )

        }
        if(state.isLoading){
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }




    }






}

