import React, { useEffect, useState, useRef } from 'react';
import NavBar from '../components/NavBar/NavBar.component';
import styles from './Home.module.css';
import { FaTrash } from "react-icons/fa";
import { MdEdit } from "react-icons/md";
import Modal from '../components/Modal/Modal.component';

function Home() {
    const [data, setData] = useState([]);
    const [idValue, setIdValue] = useState(0);
    const [lineMarkValue, setLineMarkValue] = useState("");
    const [mmLineValue, setMmLineValue] = useState("");
    const [isValueChanged, setIsValueChanged] = useState(true);

    const editItem = useRef<HTMLDialogElement>(null);

    function OpenEditItem() {
        editItem.current?.showModal();
    }

    useEffect(() => {
        if (idValue.length > 0 && lineMarkValue.length > 0 && mmLineValue.length > 0) {
            setIsValueChanged(false);
        } else {
            setIsValueChanged(true);
        }
    }, [idValue, lineMarkValue, mmLineValue]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch('http://localhost:8080/loja-pesca', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                });
                
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
            
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            if (response.ok) {
                alert('Item Cadastrado com sucesso!');
                window.location.reload();   
            }
        } catch (error) {
            alert('Erro ao cadastrar!');
        }
    }

    const DeleteItem = async (e, id) => {
        e.preventDefault();
        try {
            const response = await fetch(`http://localhost:8080/loja-pesca/${id}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                }}
            );
            
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            if (response.ok) {
                alert('Item excluido com sucesso!');
                window.location.reload();   
            }
        } catch (error) {
            alert('Erro ao excluir!');
        }
    }

    return (
        <div style={{ position: 'relative' }}>
            <NavBar />
            <div className={styles.container}>
                <section className={styles.sectionProducts} id='Produtos'>
                    <h2 className={styles.h2}>Produtos</h2>
                    <div className={styles.divItems}>
                        {data.map((item) => (
                            <div key={`${item.id}-${Math.random()}`} className={styles.cardItems}>
                                <h3 className={styles.h3Card}>{item.lineMark}</h3>
                                <p className={styles.paragraphCard}>{item.mmLine}</p>
                                <MdEdit className={styles.iconeEdit} onClick={OpenEditItem}/>
                                <FaTrash className={styles.iconTrash} onClick={(e) => DeleteItem(e, item.id)}/>
                            </div>
                        ))}
                    </div>
                </section>
                <Modal teste={editItem}/>
                <section id='Cadastrar' className={styles.sectionAddProduct}>
                    <h2 className={styles.h2Products}>Cadastrar Produto</h2>
                    <div className={styles.containerForm}>
                        <form className={styles.form}>
                            <div>
                                <p> ID do produto:</p>
                                <input 
                                    type="text" 
                                    placeholder="1" 
                                    onChange={(e) => setIdValue(e.target.value)}
                                />
                            </div>
                            <div>
                                <p> Marca da linha:</p>
                                <input 
                                    type="text" 
                                    placeholder="ZEEO" 
                                    onChange={(e) => setLineMarkValue(e.target.value)}
                                />
                            </div>
                            <div>
                                <p> mm Linha: </p>
                                <input 
                                    type="text" 
                                    placeholder="0.35mm" 
                                    onChange={(e) => setMmLineValue(e.target.value)}
                                />
                            </div>
                            <button 
                                type="submit" 
                                className={`${styles.button} ${isValueChanged ? styles.buttonDisabled : styles.buttonAdd}`}
                                onClick={PostItem}
                                disabled={isValueChanged}
                            >
                                Cadastrar
                            </button>
                        </form>
                    </div>
                </section>
            </div>
        </div>
    );
}

export default Home;
