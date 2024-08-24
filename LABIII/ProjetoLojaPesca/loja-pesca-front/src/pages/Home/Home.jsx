import React, { useEffect, useState, useCallback } from 'react';
import NavBar from '../../components/NavBar/NavBar.component';
import styles from './Home.module.css';
import Layout from '../../components/Layout/Layout.component';

function Home() {
    
    return (
        <Layout>
            <div className={styles.subContainer}>
                <h2>HomePage</h2>
            </div>
        </Layout>
    );
}

export default Home;
