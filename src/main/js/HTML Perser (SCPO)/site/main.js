'use strict';
const express = require('express');
const app = express();
app.use(express.static('./'));
app.listen(8001, ()=> {
  console.log('Express Server 01');
});