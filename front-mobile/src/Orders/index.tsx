
import React, { useEffect, useState } from 'react';
import { StyleSheet, ScrollView, Alert, Text } from 'react-native';

import { fetchOrders } from '../api';
import Header from '../Header';
import OrderCard from '../OrderCard';



function Orders() {
  useEffect(() => {
    fetchOrders()
    .then(Response => console.log(Response.data))
    .catch(error => console.log(error));
  }, []);

  return (
   <>
   <Header />
    <ScrollView style={styles.container}>
      <OrderCard />
      <OrderCard />
      <OrderCard />
    </ScrollView> 
   </>
  );
}

const styles = StyleSheet.create({
  container:{
    paddingRight: '5%',
    paddingLeft: '5%',

  }
  

});

export default Orders;