import React, {useEffect, useState} from 'react';
import NavBar from '../components/NavBar/NavBar.component';
import styles from './Home.module.css';

function Home() {
    const [data, setData] = useState([]);
    const [idValue , setIdValue] = useState(0);
    const [lineMarkValue, setLineMarkValue] = useState("");
    const [mmLineValue, setMmLineValue] = useState("");
    console.log('idValue', idValue);
    console.log('lineMarkValue', lineMarkValue);
    console.log('mmLineValue', mmLineValue);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8080/loja-pesca', {
                    method: 'GET',
                    cors: 'no-cors',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                }

                );
                
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }

                const result = await response.json();
                setData(result);
            } catch (error) {
                console.log('error', error);
            }
        };
        fetchData();
    }, []);



    const PostItem = async (e) =>  {
        e.preventDefault();
            try {
                const response = await fetch('http://localhost:8080/loja-pesca', {
                    method: 'POST',
                    body: JSON.stringify({
                        id: idValue,
                        lineMark: lineMarkValue,
                        mmLine: mmLineValue
                    }),
                    headers: {
                        'Content-Type': 'application/json',
                    }}
                );
                
                console.log('response', response);

                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }

                if (response.ok === true) {
                    alert('Item Cadastrado com sucesso!')
                    window.location.reload();   
                }
            } catch (error) {
                alert('Erro ao cadastrar!');
            }
    }

    return (
        <>
            <NavBar />
            <div className={styles.container}>
                <section className={styles.containerProducts}>
                    <h2 className={styles.h2}>Produtos</h2>
                    <div className={styles.divItems}>
                    {data.map((item) => (
                        <div key={`${item.id}-${Math.random()}`} className={styles.cardItems}>
                            <h3 className={styles.h3Card}>{item.lineMark}</h3>
                            <p className={styles.paragraphCard}>{item.mmLine}</p>
                            <button className={styles.buttonCard}>Acessar produto</button>
                        </div>
                    ))}
                    </div>
                </section>
                <section>
                    <h2 className={styles.h2}>Cadastrar Produto</h2>
                    <div className={styles.containerForm}>
                        <form className={styles.form}>
                            <div>
                                <p> ID do produto:</p>
                                <input 
                                    type="text" 
                                    placeholder="LineMark" 
                                    onChange={(e) => setIdValue(e.target.value)}
                                />
                            </div>
                            <div>
                                <p> Marca da linha:</p>
                                <input 
                                    type="text" 
                                    placeholder="LineMark" 
                                    onChange={(e) => setLineMarkValue(e.target.value)}
                                />
                            </div>
                            <div>
                                <p> mm Linha: </p>
                                <input 
                                    type="text" 
                                    placeholder="LineMark" 
                                    onChange={(e) => setMmLineValue(e.target.value)}
                                />
                            </div>
                            <button 
                                type="submit" 
                                className={styles.button}
                                onClick={PostItem}
                            >
                                Cadastrar
                            </button>
                        </form>
                    </div>
                </section>
            </div>
        </>
    );
}

export default Home;
