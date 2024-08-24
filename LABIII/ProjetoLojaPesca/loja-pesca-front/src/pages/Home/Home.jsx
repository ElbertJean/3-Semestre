import React, {useState, useEffect} from 'react';
import styles from './Home.module.css';
import Layout from '../../components/Layout/Layout.component';

import imageHeader from '../../assets/imageHeader.png';
import Button from '../../components/Button/Button.component';

import artigosPesca from '../../assets/artigosPesca.png';
import artigosAgropecuaria from '../../assets/artigosAgropecuaria.png';
import artigosEcossistemas from '../../assets/artigosEcossistemas.png';
import InputText from '../../components/Input/InputText/InputText.component';

import { AiOutlineLoading3Quarters } from "react-icons/ai";

function Home() {

    const [nomeValue, setNomeValue] = useState("");
    const [telValue, setTelValue] = useState("");
    const [emailValue, setEmailValue] = useState("");
    const [messageValue, setMessageValue] = useState("");

    const [disabledButton, setDisabledButton] = useState(true);

    const [loading, setLoading] = useState(false);

    useEffect(() => {
        if (nomeValue.length > 0 && telValue.length > 0 && emailValue.length > 0 && messageValue.length > 0) {
            setDisabledButton(false);
        } else {
            setDisabledButton(true);
        }
    },[nomeValue, telValue, emailValue, messageValue]);

    const HandleSendEmail = async (e) => {
        e.preventDefault();

        setLoading(true);

        const response = await fetch('http://localhost:8080/loja-pesca/send-email', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                nome: nomeValue,
                telefone: telValue,
                email: emailValue,
                mensagem: messageValue,
            }),
        });
    
        if (response.ok) {
            setLoading(false);
            alert('Email enviado com sucesso!');
            setNomeValue("");
            setTelValue("");
            setEmailValue("");
            setMessageValue("");

        } else {
            setLoading(false);
            alert('Falha ao enviar o email.');
        }
    };
    
    return (
        <Layout>
            {/* start section header */}
            <section className={styles.containerLanding}>
                <div className={styles.divImageLanding}>
                    <img className={styles.imageLanding} src={imageHeader} alt="imageHeader"/>
                </div>
                <div className={styles.divInfoLanding}>
                    <div className={styles.cardInfoLanding}>
                        <h3 className={styles.titleLanding}>Produtos de pesca, Agropecuária e Ecossistemas</h3>
                        <p className={styles.paragraphLanding}>
                        Temos todos os itens para garantir o melhor desempenho na sua pescaria, com qualidade superior e preços imbatíveis. Desde as varas de pesca mais resistentes até os anzóis mais afiados, oferecemos uma ampla gama de produtos para atender a todas as suas necessidades. Seja você um pescador iniciante ou experiente, nossa loja é o lugar certo para encontrar tudo o que precisa para uma pescaria bem-sucedida. Aproveite nossas ofertas e prepare-se para capturar grandes momentos!
                        </p>
                        <Button title="Ver produtos" className={styles.buttonLanding}/>
                    </div>
                </div>
            </section>
            {/* end section header */}

            {/* start section performance */}
            <section className={styles.sectionPadding}>
                <h2 className={styles.titlePerformance}>O que você vai encontrar aqui?</h2>
                <div className={styles.divFlexPerformance}>
                    <div className={styles.divPerformanceLeft}>
                        <div className={styles.divPerformanceInfo}>
                            <h3 className={styles.titlePerformanceInfoLeft}>Artigos de Pesca</h3>
                            <p className={styles.paragraphPerformanceInfoLeft}>A área de artigos de 
                            pesca é um verdadeiro paraíso para os amantes da pescaria. Oferecemos uma seleção 
                            diversificada de equipamentos, desde varas e carretilhas de alta performance até iscas 
                            artificiais e acessórios essenciais.</p>
                            <p className={styles.paragraphPerformanceInfoLeft}>Cada produto é escolhido com rigor 
                            para garantir durabilidade, precisão e eficiência em cada pescaria. Seja qual for o seu 
                            estilo de pesca ou o seu nível de experiência, aqui você encontrará tudo o que precisa 
                            para tornar suas jornadas na água ainda mais produtivas e prazerosas.</p>
                        </div>
                        <div className={styles.divPerformanceImage}>
                            <img className={styles.imagePerformance} src={artigosPesca} alt="artigosPesca" />
                        </div>
                    </div>
                    <div className={styles.divPerformanceRight}>
                        <div className={styles.divPerformanceImage}>
                            <img className={styles.imagePerformance} src={artigosAgropecuaria} alt="artigosAgropecuaria" />
                        </div>
                        <div className={styles.divPerformanceInfo}>
                            <h3 className={styles.titlePerformanceInfoRight}>Agropecuária</h3>
                            <p className={styles.paragraphPerformanceInfoRight}>A seção de agropecuária é dedicada a 
                            fornecer tudo o que você precisa para o cuidado e manejo eficiente do seu campo ou criação. 
                            Oferecemos uma ampla gama de produtos, desde rações de alta qualidade e suplementos alimentares 
                            até ferramentas e equipamentos agrícolas essenciais.</p>
                            <p className={styles.paragraphPerformanceInfoRight}>Com foco na qualidade e no bem-estar animal, 
                            nossos itens são escolhidos para garantir que você obtenha os melhores resultados em suas 
                            atividades rurais. Seja na criação de gado, cultivo ou cuidados diários, estamos aqui para apoiar 
                            o sucesso do seu negócio.</p>
                            <p className={styles.paragraphPerformanceInfoRight}>Além dos produtos essenciais, também oferecemos 
                            uma linha completa de soluções para irrigação, controle de pragas e fertilização, ajudando você a 
                            maximizar a produtividade do seu campo. Nossos especialistas estão disponíveis para orientar e 
                            recomendar os melhores produtos para suas necessidades específicas, garantindo que você tenha 
                            acesso às tecnologias mais avançadas e práticas do mercado.</p>
                        </div>
                    </div>
                    <div className={styles.divPerformanceLeft}>
                        <div className={styles.divPerformanceInfo}>
                            <h3 className={styles.titlePerformanceInfoLeft}>Ecossistemas</h3>
                            <p className={styles.paragraphPerformanceInfoLeft}>A seção de ecossistemas é dedicada 
                            a fornecer soluções sustentáveis para o manejo e preservação de ambientes naturais. Oferecemos produtos 
                            que auxiliam na manutenção de lagos, rios e outras áreas aquáticas, promovendo um equilíbrio saudável 
                            e favorecendo a biodiversidade.</p>
                            <p className={styles.paragraphPerformanceInfoLeft}>Desde plantas aquáticas nativas até sistemas de 
                            filtragem e aeradores, nosso objetivo é ajudar você a criar e manter ecossistemas equilibrados e 
                            prósperos. Seja para projetos de revitalização ou manutenção de habitats naturais, estamos prontos 
                            para apoiar suas iniciativas ambientais.</p>
                        </div>
                        <div className={styles.divPerformanceImage}>
                            <img className={styles.imagePerformance} src={artigosEcossistemas} alt="artigosEcossistemas" />
                        </div>
                    </div>
                </div>
            </section>
            {/* end section performance */}

            {/* start section Location */}
            <section className={styles.containerAboutJacare}>
                <h2 className={styles.titleAboutJacare}>Onde estamos localizados?</h2>
                <div className={styles.divAboutJacare}>
                    <div className={styles.divTextAboutJacare}>
                        <p className={styles.paragraphAboutJacare}>
                            Localizados há mais de 10 anos no bairro Campos de São José, em São José 
                            dos Campos. Nossa loja se consolidou na região como referência para pescadores, 
                            produtores rurais e entusiastas da natureza, oferecendo uma ampla gama de produtos 
                            com qualidade e confiança.
                        </p>
                    </div>
                    <div className={styles.divTextAboutJacare}>
                        <p className={styles.paragraphAboutJacareD}>
                        Avenida dos Pescadores, 1234,<br/>Campos de São José,<br/>São José dos Campos, SP.
                        </p>
                    </div>
                </div>
            </section>
            {/* end section Location */}

            {/* start Form */}
            <section className={styles.sectionForm}>
                {loading && (
                    <div className={styles.loadingForm}>
                        <AiOutlineLoading3Quarters className={styles.loading} />
                    </div>
                )}
                <div className={styles.divInfoForm}>
                    <div className={styles.cardInfoForm}>
                        <h3 className={styles.titleForm}>Faça já o seu pedido!</h3>
                        <p className={styles.paragraphForm}>Não perca tempo e garanta tudo o que você precisa para 
                        sua pescaria, agropecuária ou projeto de ecossistema. Com apenas alguns cliques, você 
                        pode escolher os melhores produtos, aproveitar nossas ofertas e receber tudo diretamente 
                        na sua casa. Navegue pelo nosso catálogo, selecione o que deseja e finalize seu pedido com 
                        segurança e facilidade. Estamos prontos para atender você com rapidez e eficiência. 
                        Faça já o seu pedido e prepare-se para equipar-se com o melhor!
                        </p>
                    </div>
                </div>
                <form className={styles.form}>
                    <div className={styles.containerGroupForm}>
                        <div className={styles.divInputForm}>
                            <label className={styles.labelForm}>Nome:</label>
                            <InputText 
                                placeholder="John Doe" 
                                className={styles.inputForm} 
                                onChange={(e) => setNomeValue(e.target.value)}
                                value={nomeValue}
                            />
                            {/* <p className={styles.form-error} data-field=}name}>Insira um nome válido! Ex: John Doe</p> */}
                        </div>
                        <div className={styles.divInputForm}>
                            <label className={styles.labelForm}>Telefone:</label>
                            <InputText 
                                placeholder="(00) 91234-5678" 
                                className={styles.inputForm} 
                                onChange={(e) => setTelValue(e.target.value)}
                                value={telValue}
                            />
                        </div>
                        <div className={styles.divInputForm}>
                            <label className={styles.labelForm}>Email:</label>
                            <InputText
                                placeholder="johndoe@email.com" 
                                className={styles.inputForm}
                                onChange={(e) => setEmailValue(e.target.value)}
                                value={emailValue}
                            />
                        </div>
                        <div className={styles.divInputForm}>
                            <label className={styles.labelForm}>Mensagem:</label>
                            <textarea 
                                className={styles.textInputForm} 
                                rows="10" 
                                maxlength="500" 
                                onChange={(e) => setMessageValue(e.target.value)}
                                value={messageValue}
                            ></textarea>
                        </div>
                        <div className={styles.divButtonForm}>
                            <Button 
                                title="Enviar" 
                                className={`${styles.buttonForm} ${disabledButton ? styles.buttonFormDisabled : ''}` }
                                disabled={disabledButton}
                                onClick={(e) => HandleSendEmail(e)}
                            />
                        </div>
                    </div>
                </form>
            </section>
            {/* end Form */}
        </Layout>
    );
}

export default Home;
