const express = require('express');
const axios = require('axios');
const cors = require('cors');

const app = express();
const port = 3003;
app.use(cors());
app.use(express.json());

app.get('/loja-pesca', async (req, res) => {
  try {
    const response = await axios.get('http://localhost:8080/loja-pesca');
    res.json(response.data);
  } catch (error) {
    console.error('Error fetching data from Spring Boot API:', error);
    res.status(500).json({ message: 'Error fetching data from Spring Boot API' });
  }
});

app.listen(port, () => {
  console.log(`Express server running at http://localhost:${port}`);
});
