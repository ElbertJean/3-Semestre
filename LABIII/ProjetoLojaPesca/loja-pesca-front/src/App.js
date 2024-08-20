import { useState, useEffect } from 'react';
import './App.css';

function App() {
  
  const [data, setData] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  console.log('data', data);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:3003/loja-pesca');
        
        if (!response.ok) {
          throw new Error(`HTTP error! Status: ${response.status}`);
        }

        const result = await response.json();
        setData(result);
        setIsLoading(false);
      } catch (error) {
        console.log('error', error);
      }
    };

    fetchData();
  }, []);

  return (
    <div>
      {data.map((item) => (
          <div key={item.id}>
            <h1>{item.lineMark}</h1>
            <p>{item.mmLine}</p>
          </div>
      ))}
    </div>
  );
}

export default App;
