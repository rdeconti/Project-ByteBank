<!--
********************************************************************************
Project: Seniores Digitais - Labora/Alura/Oracle ONE
Programmer: Rosemeire Deconti
Date: January / 2021
Challenge: Create Web Page ByteBank and apply JAVA knowledge
********************************************************************************
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<!--------------------------------------------------------------- START HTML -->
<html lang="pt-br" dir="ltr">

  <!------------------------------------------------------------- START HEAD -->
  <head>
  
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- Reset style sheets --------------------------------------------------->
	<link rel="stylesheet" href="stylesheets/reset.css">
	
    <!-- Style sheets --------------------------------------------------------->
    <link rel="stylesheet" href="web-stylesheets/app.css">
    <link rel="stylesheet" href="web-stylesheets/background.css">
    <link rel="stylesheet" href="web-stylesheets/beneficios.css">
    <link rel="stylesheet" href="web-stylesheets/cabecalho.css">
    <link rel="stylesheet" href="web-stylesheets/container.css">
    <link rel="stylesheet" href="web-stylesheets/contato.css">
    <link rel="stylesheet" href="web-stylesheets/footer.css">
    <link rel="stylesheet" href="web-stylesheets/form-newsletter.css">
    <link rel="stylesheet" href="web-stylesheets/main-cursos.css">
    <link rel="stylesheet" href="web-stylesheets/planos.css">
    <link rel="stylesheet" href="web-stylesheets/sobre.css">
    <link rel="stylesheet" href="web-stylesheets/video.css">
    <link rel="stylesheet" href="web-stylesheets/youtube.css">
    
	  <!-- Windows FAVICON  ----------------------------------------------------->
    <link rel="shortcut icon" href="web-favicon/favicon.ico" />
    
    <!-- Windows tab name ----------------------------------------------------->
    <title>ByteBank | Principal</title>
    
    <!-- https://fonts.google.com/ -------------------------------------------->
    <link
        href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet">
        
  </head>
  <!------------------------------------------------------------- START BODY -->
  <body>
    <div class="background">
      <!------------------------------------------------------- START HEADER -->
      <header class="cabecalho">
        <div class="container">
          <a class="cabecalho-logo" href="index.html">
            <img src="images/musicdot-logo-light.svg" title="Ir para a página inicial da Musicdot" alt="Musicdot">
          </a>
          <nav>
            <ul class="cabecalho-menu">
                <li> <a href="sobre.html#contato"> Contato </a> </li>
                <li> <a href="#"> Entrar </a> </li>
                <li class="button-pink"> <a href="#"> Matricule-se </a> </li>
            </ul>
          </nav>
        </div>
      </header>
      <!--------------------------------------------------------- START MAIN -->
      <main>
        <div class="container">
          <section class="cursos">
            <article class="cursos-banner ">
                <h1 class="cursos-title">Cursos Online de <span class="--destaque">Música</span></h1>
                <p>Comece agora e aprenda sua primeira música em 10 minutos!</p>
                <a href="cursos.html" class="cursos-matricula button-pink2">Matricule-se</a>
            </article>
           </section>
          <nav>
            <ul class="ul-main-cursos">
                <li class="curso-tecladopiano"><a href="#">Teclado e Piano</a></li>
                <li class="curso-violaoguitarra"><a href="#">Violão e Guitarra</a></li>
                <li class="curso-baixo"><a href="#">Baixo</a></li>
                <li class="curso-bateria curso--destaque"><a href="#">Bateria</a></li>
                <li class="curso-percursao"><a href="#">Percursão</a></li>
                <li class="curso-canto curso--destaque2"><a href="#">Canto</a></li>
                <li class="curso-audio"><a href="#">Áudio</a></li>
                <li class="curso-teoria"><a href="#">Teoria</a></li>
                <li class="curso-sopro"><a href="#">Sopro</a></li>
                <li class="curso-cordas"><a href="#">Cordas</a></li>
            </ul>
          </nav>
        </div>
        <!--------------------------------------------------- START "VÍDEOS" -->
        <section class="video">
          <div class="container">
            <video controls src='video/video-promocional.mp4' class="video--mobile"
                poster="images/video-principal-mobile.png">
            </video>
            <video controls src='video/video-promocional.mp4' class="video--desktop"
                poster="images/video-principal.png">
            </video>
            <article class="video-textos">
                <h2 class='video-title'>Estude com os melhores professores</h2>
                <p>Aprenda no seu ritmo, sem sair de casa.</p>
            </article>
          </div>
        </section>
        <!--------------------------------------------------- START "PLANOS" -->
        <section class="planos">
          <div class="container">
            <h2 class="planos-title">Acesso ilimitado a todos os cursos</h2>
            <div class='card-anual'>
                <span class="plano-destaque"> + Assinado</span>
                <article class="box-plano card1">
                    <h3 class="plano-title">Plano Anual</h3>
                    <p>12x <span>R$ 50,00</span> </p>
                    <p>Valor total de R$600,00</p>
                    <p class='aluralingua'>Acesso à Alura Lingua</p>
                    <a class='plano-button'>matricule-se</a>
                </article>
            </div>
            <article class="box-plano card2">
                <h3 class="plano-title">Plano Semestral</h3>
                <p>12x <span>R$ 60,00</span></p>
                <p>Valor total de R$360,00</p>
                <a class='plano-button' href="">matricule-se</a>
            </article>
            <br>
            <div class="cardfooter">
                <p>Pagamento seguro com PayPal</p>
                <p>Oferecemos boleto à vista, <span class='bold'>basta entrar em contato</span></p>
            </div>
          </div>
        </section>
        <!----------------------------------------------- START "BENEFÍCIOS" -->
        <section class="beneficios">
          <div class="container">
            <h2 class="beneficios-title">Por que estudar na MusicDot?</h2>
            <article class="beneficio-card bcard1">
              <h3 class="beneficio-title">Tudo para você realmente aprender</h3>
              <p>Você acessa todo o conteúdo! São aulas, exercícios, play
                  backs, cifras, partituras e tira dúvidas. Estudem em qualquer lugar, qualquer dia, qualquer
                  horári o, ilimitado. Matricule-se já.
              </p>
            </article>
            <article class="beneficio-card bcard2">
              <h3 class="beneficio-title">Nenhuma dúvida sem resposta</h3>
              <p>Dúvidas são importantes para o seu aprendizado, e as dif
                  iculdades são normais. Na MusicDot você estuda com todo o suporte necessário. Além de todo
                  conteúd
                  o, você tira dúvidas.
              </p>
            </article>
            <article class="beneficio-card bcard3">
              <h3 class="beneficio-title">Didática cuidadosa que te faz aprender</h3>
              <p>Saber tocar não quer dizer saber ensinar. Na MusicDot vo
                  cê encontra os dois! Nosso orgulho é justo o extremo cuidado didático que temo com as aulas.
                  Inves
                  timos muito tempo.
              </p>
            </article>
            <article class="beneficio-card bcard4">
              <h3 class="beneficio-title">Estudar online é a melhor opção</h3>
              <p>Aprender em DVD e revistinha de banca são coisas do pass
                  ado! Estudar com um professor particular é bom, mas quem é o seu professor? A MusicDot te
                  oferece
                  a melhor aula, a qualquer hora.
              </p>
            </article>
          </div>
        </section>
        <!-------------------------------------------------- START "YOUTUBE" -->
        <section class="youtube">
          <div class="container">
            <article class="youtube-canal youtube-informacao icone-youtube --largura-grande">
                <h2 class="canal-titulo">Nosso canal no YouTube</h2>
                <p class="canal-texto">Cursos online de Teclado, Piano, Canto, Violão, Guitarra, Teoria Musical e mais!</p>
                <a href="https://www.youtube.com/user/musicdotonline" class="canal-button">Ver Canal</a>
            </article>
            <article class="youtube-canal chamada-youtube-video1">
                <a class="video-descricao" href="#">
                    <h2 class="descricao-titulo">Aula de Canto para Iniciantes (dicas básicas)</h2>
                    <p class="descricao-texto">Nessa aula a professora Anny Cee dá as primeiras dicas para você
                        começar o seu estudo do Canto.
                    </p>
                </a>
            </article>
            <article class="youtube-canal youtube-video2">
                <a class="video-descricao" href="#">
                    <h2 class="descricao-titulo">Toque teclado em 10 minutos! (Aula de teclado para iniciantes)
                    </h2>
                    <p class="descricao-texto">Essa é a primeira aula do curso de teclado da MusicDot.
                        Aqui você aprenderá a nomear todas...
                    </p>
                </a>
            </article>
          </div>
        </section>
        <!------------------------------------------------------ START "APP" -->
        <section class="app">
          <div class="container">
            <h2 class="app-title">Estude em qualquer lugar com o APP</h2>
            <p class="app-texto">Com o aplicativo da MusicDot você baixa as aulas para estudar offline e fazer os exercícios. disponível para android e iOS. Já é aluno? Baixe já.</p>
            <a href="" class="app-button app-android">Android</a>
            <a href="" class="app-button app-apple">iOS</a>
          </div>
        </section>
      </main>
    </div>
    <!--------------------------------------------------------- START FOOTER -->
    <footer class="footer">
      <div class="container">
        <!------------------------------------------------------ START INFOS -->
        <section class="footer-section --infos" role="infos">
          <a class="footer-logo" href="index.html">
              <img src="images/logo.svg" title="Ir para a página inicial da Musicdot" alt="Musicdot">
          </a>
          <p class="footer-text">
              AOVS Sistemas de Informática S.A <br>
              Rua Vergueiro, 3185, 8º andar<br>
              Vila Mariana<br>
              São Paulo - SP
          </p>
          <ul class="ul-socialmedia ">
            <li><a class="footer-logo-media" href="https://www.facebook.com/musicdotonline"><img
                        src="images/footer-icone-facebook.svg" alt=""></a>
            </li>
            <li><a class="footer-logo-media" href="https://www.youtube.com/user/musicdotonline"><img
                        src="images/footer-icone-youtube.svg" alt=""></a>
            </li>
            <li><a class="footer-logo-media" href="https://www.instagram.com/musicdotonline"><img
                        src="images/footer-icone-instagram.svg" alt=""></a>
            </li>
          </ul>
        </section>
        <!--------------------------------------------------- START CURSOS 1 -->
        <section class="footer-section --cursos" role="cursos">
          <h3 class="footer-title">Cursos da MusicDot</h3>
          <nav>
            <ul class="ul-cursos">
                <li><a href="">Cursos de Teclado & Piano</a></li>
                <li><a href="">Cursos de Violão/Guitarra</a></li>
                <li><a href="">Cursos de Baixo</a></li>
                <li><a href="">Cursos de Bateria</a></li>
                <li><a href="">Cursos de Percussão</a></li>
                <li><a href="">Cursos de Canto</a></li>
                <li><a href="">Cursos de Áudio</a></li>
                <li><a href="">Cursos de Teoria</a></li>
                <li><a href="">Cursos de Sopro</a></li>
                <li><a href="">Cursos de Cordas</a></li>
            </ul>
          </nav>
        </section>
        <!--------------------------------------------------- START CURSOS 2 -->
        <section class="footer-section --links" role="links">
          <h3 class="footer-title">MusicDot</h3>
          <nav>
            <ul class="ul-cursos">
                <li><a href="">Apostila</a></li>
                <li><a href="">E-book</a></li>
                <li><a href="">Login</a></li>
                <li><a href="">Matricule-se</a></li>
                <li><a href="">Perguntas Frequentes</a></li>
                <li><a href="">Para Escolas</a></li>
                <li><a href="">Contato</a></li>
            </ul>
          </nav>
        </section>
        <!---------------------------------------------------- START CONTATO -->
        <section class="footer-section --form" role="form">
          <h3 class="footer-title">Receba novidades e lançamentos</h3>
          <form class="form-news">
              <label class="form-label">Seu e-mail pessoal</label>
              <input type="text">
              <button class="form-button">ok</button>
          </form>
        </section>
      </div>
    </footer>
  </body>
</html>