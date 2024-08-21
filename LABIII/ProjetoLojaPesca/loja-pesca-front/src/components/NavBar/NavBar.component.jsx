import react from 'react';
import styles from './NavBar.module.css';
import logo from '../../assets/logo.png';

const NavBar = () => {

    const scrollToSection = (sectionId) => {
        const section = document.getElementById(sectionId);
        if (section) {
            section.scrollIntoView({ behavior: 'smooth' });
        }
    };

    return (
        <div className={styles.container}>
            <div className={styles.divTitle}>
                <img src={logo} className={styles.logo}/>
                <h1 className={styles.h1}>Agro Pesca Jacaré</h1>
            </div>
            <nav className={styles.nav}>
                <button className={styles.button} onClick={() => scrollToSection('Cadastrar')}>Cadastrar produto</button>
                <button className={styles.button} onClick={() => scrollToSection('Produtos')}>Produtos</button>
            </nav>                
        </div>
    );
};

export default NavBar;