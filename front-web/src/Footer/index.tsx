import './styles.css';
import { ReactComponent as Github } from './github.svg';
import { ReactComponent as Linkedin } from './linkedin.svg';

function Footer() {
  return (
   <footer className="main-footer">
       App desenvolvido por Fabiano Carregas Dev Java Jr.
        <div className="footer-icons">
            <a href="https://www.linkedin.com/in/fabiano-carregas/" target="_new">
                <Linkedin />
            </a>
            <a href="https://github.com/FabianoCarregas" target="_new">
                <Github />
            </a>

        </div>
   </footer>

  );
}

export default Footer;
