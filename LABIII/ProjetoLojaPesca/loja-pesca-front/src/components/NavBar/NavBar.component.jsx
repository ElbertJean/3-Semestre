import React, {  useState, useRef} from 'react';
import styles from './NavBar.module.css';
import logo from '../../assets/logo.png';
import { useNavigate } from 'react-router-dom';

const NavBar = () => {

    const navigate = useNavigate();
    
    return (
        <div className={styles.container}>
            <div className={styles.divTitle}>
                <img src={logo} className={styles.logo}/>
                <h1 className={styles.h1}>Agro Pesca Jacaré</h1>
            </div>
            <nav className={styles.nav}>
                <button className={styles.button} onClick={() => navigate('/')}>Página inicial</button>
                <button className={styles.button} onClick={() => navigate('/products')}>Produtos</button>
                <button className={styles.button} onClick={() => navigate('/register')}>Cadastrar Produto</button>
            </nav>                
        </div>
    );
};

export default NavBar;