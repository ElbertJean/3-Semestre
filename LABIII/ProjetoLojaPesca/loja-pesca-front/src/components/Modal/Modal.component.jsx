import React, {useState, useEffect} from 'react';
import styles from './Modal.module.css';
import { IoCloseSharp } from "react-icons/io5";

import Button from '../Button/Button.component';
import InputText from '../Input/InputText/InputText.component';

const Modal = ({ closeModal, item, setShowModal, setShouldFetchData }) => {
    
    const [idValue, setIdValue] = useState("");
    const [lineMarkValue, setLineMarkValue] = useState("");
    const [mmLineValue, setMmLineValue] = useState("");

    const [disabledButton, setDisabledButton] = useState(true);
    
    useEffect(() => {
        if (item) {
            setIdValue(item.id);
            setLineMarkValue(item.lineMark);
            setMmLineValue(item.mmLine);
        }
    }, [item]);
    
    useEffect(() => {
        if (lineMarkValue.length > 0 && mmLineValue.length > 0) {
            setDisabledButton(false);
        } else {
            setDisabledButton(true);
        }
    }, [lineMarkValue, mmLineValue]);

    const PutItem = async (e) =>  {
        e.preventDefault();
        try {
            const response = await fetch(`http://localhost:8080/loja-pesca/${idValue}`, {
                method: 'PUT',
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
                alert('Item editado com sucesso!');
                setShowModal(false);
                setShouldFetchData(true);
            }
        } catch (error) {
            alert('Erro ao cadastrar!');
        }
    }
    
    return (
        <div className={styles.modal}>
            <IoCloseSharp className={styles.iconClose} onClick={closeModal} />
            <h3 className={styles.h3}>Editar produto</h3>
            <form className={styles.form}>
                <div className={styles.divForm}>
                    <p className={styles.labelInputForm}> ID do produto:</p>
                    <InputText 
                        value={idValue} 
                        readOnly
                        disabled
                    />
                </div>
                <div className={styles.divForm}>
                    <p className={styles.labelInputForm}> Marca da linha:</p>
                    <InputText 
                        value={lineMarkValue} 
                        onChange={(e) => setLineMarkValue(e.target.value)}
                    />
                </div>
                <div className={styles.divForm}>
                    <p className={styles.labelInputForm}> mm Linha: </p>
                    <InputText 
                        value={mmLineValue} 
                        onChange={(e) => setMmLineValue(e.target.value)}
                    />
                </div>
                <Button 
                    type="submit" 
                    className={`${disabledButton ? styles.buttonDisabled : styles.buttonAdd}`} 
                    onClick={PutItem}
                    disabled={disabledButton}
                    title="Atualizar"
                />
            </form>
        </div>
    );
};

export default Modal;
