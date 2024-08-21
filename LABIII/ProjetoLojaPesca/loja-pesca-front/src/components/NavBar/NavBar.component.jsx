import react from 'react';
import styles from './NavBar.module.css';
import logo from '../../assets/logo.png';

const NavBar = () => {
    return (
        <div className={styles.container}>
            <div className={styles.divTitle}>
                <img src={logo} />
                <h1>Agro Pesca Jacareí</h1>
            </div>
            <nav className={styles.nav}>
                <a href='#'>Produtos</a>
                <a href='#'>Cadastrar produtos</a>
                <a href='#'>Contato</a>
            </nav>                
        </div>
    );
};

export default NavBar;