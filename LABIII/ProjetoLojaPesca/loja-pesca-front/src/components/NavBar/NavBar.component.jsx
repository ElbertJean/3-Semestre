import React from 'react';
import styles from './NavBar.module.css';
import logo from '../../assets/logo.png';
import { useNavigate } from 'react-router-dom';

const NavBar = () => {

    const navigate = useNavigate();
    
    return (
        <header className={styles.header}>
            <div className={styles.divTitle}>
                <img src={logo} className={styles.logo} alt='logo'/>
                <h1 className={styles.h1}>Agro Pesca Jacaré</h1>
            </div>
            <nav className={styles.nav}>
                <button className={styles.button} onClick={() => navigate('/')}>Página inicial</button>
                <button className={styles.button} onClick={() => navigate('/products')}>Produtos</button>
                <button className={styles.button} onClick={() => navigate('/register')}>Cadastrar Produto</button>
            </nav>                
        </header>
    );
};

export default NavBar;