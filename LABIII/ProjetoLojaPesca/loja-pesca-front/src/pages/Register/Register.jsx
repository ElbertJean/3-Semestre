import React, { useState, useEffect } from 'react';
import useProductActions from '../../hooks/useProductActions';

import styles from './Register.module.css';

import Layout from '../../components/Layout/Layout.component';
import NavBar from '../../components/NavBar/NavBar.component';
import InputText from '../../components/Input/InputText/InputText.component';
import Button from '../../components/Button/Button.component';

function Register() {

    const [data, setData] = useState([]);

    const [idValue, setIdValue] = useState("");
    const [lineMarkValue, setLineMarkValue] = useState("");
    const [mmLineValue, setMmLineValue] = useState("");

    const idRandom = Math.floor(Math.random() * (10000000 - 1 + 1)) + 1;
    const [disabledButton, setDisabledButton] = useState(true);

    const { PostItem, setShouldFetchData } = useProductActions(); 

    const handlePostItem = (e) => {
        PostItem(
            e, 
            idValue, 
            lineMarkValue, 
            mmLineValue, 
            idRandom, 
            setData, 
            setShouldFetchData, 
            setIdValue, 
            setLineMarkValue, 
            setMmLineValue
        );
    };

    useEffect(() => {
        if (idValue.length > 0 && lineMarkValue.length > 0 && mmLineValue.length > 0) {
            setDisabledButton(false);
        } else {
            setDisabledButton(true);
        }
    }, [idValue, lineMarkValue, mmLineValue]);

    return(
        <Layout>
            <section id='Cadastrar'>
                <h2 className={styles.h2Products}>Cadastrar Produto</h2>
                <div className={styles.containerForm}>
                    <form className={styles.form}>
                        <div className={styles.divForm}>
                            <p className={styles.labelInputForm}> ID do produto:</p>
                            <InputText
                                placeholder="1" 
                                onChange={(e) => setIdValue(e.target.value)} 
                                value={idValue}
                            />
                        </div>
                        <div className={styles.divForm}>
                            <p className={styles.labelInputForm}> Marca da linha:</p>
                            <InputText 
                                placeholder="ZEEO" 
                                onChange={(e) => setLineMarkValue(e.target.value)} 
                                value={lineMarkValue}
                            />
                        </div>
                        <div className={styles.divForm}>
                            <p className={styles.labelInputForm}> mm Linha: </p>
                            <InputText 
                                placeholder="0.35mm" 
                                onChange={(e) => setMmLineValue(e.target.value)} 
                                value={mmLineValue}
                            />
                        </div>  
                        <Button 
                            type="submit" 
                            className={`${disabledButton ? styles.buttonDisabled : styles.buttonAdd}`} 
                            onClick={handlePostItem}
                            disabled={disabledButton}
                            title={'Cadastrar'}
                        />
                    </form>
                </div>
            </section>
        </Layout>
    )
}

export default Register;