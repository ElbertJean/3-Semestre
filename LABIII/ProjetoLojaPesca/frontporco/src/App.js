import React, { useState, useEffect } from 'react';


const App = () => {
  
  const [data, setData] = useState();
  const [line, setLine] = useState();
  const [mmLine, setMmLine] = useState();
  const [del , setDel] = useState();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/linhas');
        const json = await response.json();
        console.log('json', json);
        setData(json);
      } catch (error) {
        console.error('Erro ao buscar os dados:', error);
      }
    };
  
    fetchData();
  }, []);

  const handleSubmit = async () => {
    const response = await fetch('http://localhost:8080/linhas', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ lineMark: line, mmLine: mmLine }),
    });
    const data = await response.json();
    console.log(data);
    alert('em viado')
  };

  const handleDelete = async () => {
    const response = await fetch(`http://localhost:8080/linhas/${Number(del)}`, {
      method: 'DELETE',
    });
    const data = await response.json();
    console.log(data);
    alert('del etadu')
  };

  return (
    <>
      <h1>Todas as linhas</h1>
      {
        data && data.map((linha) => (
          <div key={linha.id}>
            <p>{linha.id}</p>
            <h2>{linha.lineMark}</h2>
            <p>{linha.mmLine}</p>
          </div>
        ))
      }
      <hr/>
      <h1>Adicionar linha</h1>
      <input type="text" placeholder="Digite a linha" onChange={(event) => setLine(event.target.value)}/>
      <input type="text" placeholder="Digite a mm da linha" onChange={(event) => setMmLine(event.target.value)}/>
      <button onClick={handleSubmit}>Enviar</button>
      <hr/>
      <h1>Deletar linha</h1>
      <input type='text' placeholder='Delete uma linha' onChange={(event) => setDel(event.target.value)}/>
      <button onClick={handleDelete}>Deletar</button>
      <hr />
    </>
  )
}

export default App;