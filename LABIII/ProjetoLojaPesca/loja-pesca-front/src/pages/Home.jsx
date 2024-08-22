import React, { useEffect, useState, useRef } from 'react';
import NavBar from '../components/NavBar/NavBar.component';
import styles from './Home.module.css';
import { FaTrash } from "react-icons/fa";
import { MdEdit } from "react-icons/md";
import Modal from '../components/Modal/Modal.component';
import Music from '../components/Music/Music.component';

function Home() {
    const [data, setData] = useState([]);
    console.log('data', data);

    const [idValue, setIdValue] = useState("");
    const idRandom = Math.floor(Math.random() * (10000000 - 1 + 1)) + 1

    const [lineMarkValue, setLineMarkValue] = useState("");
    const [mmLineValue, setMmLineValue] = useState("");

    const [disabledButton, setDisabledButton] = useState(true);
    const [selectedItem, setSelectedItem] = useState(null);

    const [showModal, setShowModal] = useState(false);

    const [shouldFetchData, setShouldFetchData] = useState(true);
    console.log('shouldFetchData', shouldFetchData);


    useEffect(() => {
        if (idValue.length > 0 && lineMarkValue.length > 0 && mmLineValue.length > 0) {
            setDisabledButton(false);
        } else {
            setDisabledButton(true);
        }
    }, [idValue, lineMarkValue, mmLineValue]);

    useEffect(() => {
        
        if (!shouldFetchData) return;

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
                setShouldFetchData(false);
            } catch (error) {
                console.log('error', error);
            }
        };
        fetchData();
    }, [shouldFetchData]);

    const PostItem = async (e) =>  {
        e.preventDefault();
        try {
            const response = await fetch('http://localhost:8080/loja-pesca', {
                method: 'POST',
                body: JSON.stringify({
                    id: idValue + idRandom,
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
                setShouldFetchData(true);

                setIdValue("");
                setLineMarkValue("");
                setMmLineValue("");
            
            }

        } catch (error) {
            alert('Erro ao cadastrar!');
        }
    }

    const handleEdit = async (item) => {
        try {
            const response = await fetch(`http://localhost:8080/loja-pesca/${item.id}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                },
            });

            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            const result = await response.json();
            setSelectedItem(result);
            setShowModal(true);
        } catch (error) {
            console.log('error', error);
        }
    };

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
                setShouldFetchData(true); 
            }
        } catch (error) {
            alert('Erro ao excluir!');
        }
    }

    return (
        <div className={styles.container}>
            <NavBar />
            <div className={styles.subContainer}>
                <section id='Cadastrar' className={styles.sectionAddProduct}>
                    <h2 className={styles.h2Products}>Cadastrar Produto</h2>
                    <div className={styles.containerForm}>
                        <form className={styles.form}>
                            <div className={styles.divForm}>
                                <p className={styles.labelInputForm}> ID do produto:</p>
                                <input 
                                    type="text" 
                                    placeholder="1" 
                                    onChange={(e) => setIdValue(e.target.value)}
                                    className={styles.inputForm}
                                    value={idValue}
                                />
                            </div>
                            <div className={styles.divForm}>
                                <p className={styles.labelInputForm}> Marca da linha:</p>
                                <input 
                                    type="text" 
                                    placeholder="ZEEO" 
                                    onChange={(e) => setLineMarkValue(e.target.value)}
                                    className={styles.inputForm}
                                    value={lineMarkValue}
                                />
                            </div>
                            <div className={styles.divForm}>
                                <p className={styles.labelInputForm}> mm Linha: </p>
                                <input 
                                    type="text" 
                                    placeholder="0.35mm" 
                                    onChange={(e) => setMmLineValue(e.target.value)}
                                    className={styles.inputForm}
                                    value={mmLineValue}
                                />
                            </div>
                            <button 
                                type="submit" 
                                className={`${styles.button} ${disabledButton ? styles.buttonDisabled : styles.buttonAdd}`}
                                onClick={PostItem}
                                disabled={disabledButton}
                            >
                                Cadastrar
                            </button>
                        </form>
                    </div>
                </section>
                <section className={styles.sectionProducts} id='Produtos'>
                    <h2 className={styles.h2}>Produtos</h2>
                    <div className={styles.divItems}>
                        {data.length > 0 ? data.map((item) => (
                            <div key={`${item.id}-${Math.random()}`} className={styles.cardItems}>
                                <h3 className={styles.h3Card}>{item.lineMark}</h3>
                                <p className={styles.paragraphCard}>{item.mmLine}</p>
                                <MdEdit className={styles.iconeEdit} onClick={() => handleEdit(item)}/>
                                <FaTrash className={styles.iconTrash} onClick={(e) => DeleteItem(e, item.id)}/>
                            </div>
                        )): (
                            <>
                                <p>Não há produtos cadastrados no momento</p>
                            </>
                        )}
                    </div>
                </section>
                {showModal ? (
                    <div className={`${styles.cardMapExpanded}`}>
                        <Modal 
                            item={selectedItem} 
                            closeModal={() => setShowModal(false)} 
                            setShowModal={setShowModal}
                            setShouldFetchData={setShouldFetchData}
                        />
                    </div>

                ): (
                    <div className={`${styles.cardMapCollapsed}`}>
                        <Modal/>
                    </div>
                )}
                <Music />
            </div>
        </div>
    );
}

export default Home;
