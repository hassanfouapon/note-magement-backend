-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 15 fév. 2023 à 12:56
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `isj_projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `annee_academique`
--

CREATE TABLE `annee_academique` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `date_cloture` datetime DEFAULT NULL,
  `date_debut` datetime DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `annee_academique`
--

INSERT INTO `annee_academique` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `date_cloture`, `date_debut`, `createur`, `modificateur`) VALUES
(16, '2022-04-08 18:47:01', '2022-04-06 18:47:01', 'respect', 'promotion', 'hassan', 'ACTIVE', '2022-04-30 18:47:01', '2022-05-12 18:47:01', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `anonymat`
--

CREATE TABLE `anonymat` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `numero_anonymat` varchar(255) DEFAULT NULL,
  `numero_table` int(11) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `est_inscrit` bigint(20) DEFAULT NULL,
  `evaluation` bigint(20) DEFAULT NULL,
  `note` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

CREATE TABLE `candidat` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) NOT NULL,
  `statut` varchar(255) NOT NULL,
  `telephone` varchar(13) DEFAULT NULL,
  `ecole_origine` varchar(255) DEFAULT NULL,
  `lieu_naissance` varchar(255) DEFAULT NULL,
  `nom_de_la_mere` varchar(255) DEFAULT NULL,
  `nom_du_pere` varchar(255) DEFAULT NULL,
  `profession_de_la_mere` varchar(255) DEFAULT NULL,
  `profession_du_pere` varchar(255) DEFAULT NULL,
  `region_origine` varchar(255) DEFAULT NULL,
  `telephone_de_la_mere` varchar(255) DEFAULT NULL,
  `telephone_du_pere` varchar(255) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `classe` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `candidat`
--

INSERT INTO `candidat` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `date_naissance`, `email`, `nom`, `prenom`, `sexe`, `statut`, `telephone`, `ecole_origine`, `lieu_naissance`, `nom_de_la_mere`, `nom_du_pere`, `profession_de_la_mere`, `profession_du_pere`, `region_origine`, `telephone_de_la_mere`, `telephone_du_pere`, `createur`, `modificateur`, `classe`) VALUES
(4, '2022-02-23 15:04:29', '2022-02-23 15:04:29', 'bon', NULL, NULL, 'ACTIVE', '2022-02-23 15:04:29', 'hassant@gmail.com', 'hassan', 'hassant', 'MASCULIN', 'ACTIVE', '698227743', 'LYNE', 'Foumban', 'SAFIATOU', 'YOUSSOUF', 'Menagere', 'Comptable', 'Ouest', '698329852', '698341863', 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

CREATE TABLE `classe` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `niveau` bigint(20) DEFAULT NULL,
  `specialite` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `createur`, `modificateur`, `niveau`, `specialite`) VALUES
(0, '2022-02-01 14:48:24', '2022-02-02 14:48:24', 'ijijij', 'tres bien', 'houssei', 'ATTENTE', 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

CREATE TABLE `discipline` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `date_retard` datetime DEFAULT NULL,
  `heure_justifie` int(11) DEFAULT NULL,
  `nb_heures_absences` int(11) DEFAULT NULL,
  `nb_retards` int(11) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `etudiant` bigint(20) DEFAULT NULL,
  `semestre` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `droit`
--

CREATE TABLE `droit` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `categorie` varchar(255) NOT NULL,
  `ecriture` bit(1) DEFAULT NULL,
  `lecture` bit(1) DEFAULT NULL,
  `modification` bit(1) DEFAULT NULL,
  `suppression` bit(1) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `role` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `email`
--

CREATE TABLE `email` (
  `objet` varchar(255) DEFAULT NULL,
  `code` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) NOT NULL,
  `statut` varchar(255) NOT NULL,
  `telephone` varchar(13) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

CREATE TABLE `enseignement` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `credit` double DEFAULT NULL,
  `heures_de_cours` int(11) DEFAULT NULL,
  `programme_de_cours` varchar(1020) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `semestre` bigint(20) DEFAULT NULL,
  `ue` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `enseignement`
--

INSERT INTO `enseignement` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `credit`, `heures_de_cours`, `programme_de_cours`, `createur`, `modificateur`, `semestre`, `ue`) VALUES
(14, '2022-04-05 18:41:46', '2022-04-07 18:41:46', 'enseignement de qualité', 'informatique', 'houssein', 'ACTIVE', 5, 12, 'de lundi à mercredi ', 0, 0, 15, 13);

-- --------------------------------------------------------

--
-- Structure de la table `enseignement_enseignants`
--

CREATE TABLE `enseignement_enseignants` (
  `code_enseignement` bigint(20) NOT NULL,
  `code_enseignant` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `envoi_message`
--

CREATE TABLE `envoi_message` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `date_envoi` datetime DEFAULT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `candidat` bigint(20) DEFAULT NULL,
  `message` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `est_inscrit`
--

CREATE TABLE `est_inscrit` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `statut` varchar(255) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `candidat_inscrit` bigint(20) DEFAULT NULL,
  `enseignement` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `code_authentification` varchar(255) NOT NULL,
  `matricule` varchar(255) NOT NULL,
  `code` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`code_authentification`, `matricule`, `code`) VALUES
('cdt2', '6983tlo41863', 4);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

CREATE TABLE `evaluation` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `date_evaluation` datetime DEFAULT NULL,
  `statut` varchar(255) NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `type_evaluation` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `date_evaluation`, `statut`, `createur`, `modificateur`, `type_evaluation`) VALUES
(14, '2022-04-15 10:13:17', '2022-04-15 10:13:17', 'epreuve pas facile', 'java', NULL, 'ACTIVE', '2022-11-01 15:55:52', 'ACTIVE', 0, 0, 9);

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

CREATE TABLE `filiere` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `filiere`
--

INSERT INTO `filiere` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `createur`, `modificateur`) VALUES
(0, '2022-02-10 15:34:54', '2022-02-25 15:34:54', 'informatique', 'inf', 'info', 'ATTENTE', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(16);

-- --------------------------------------------------------

--
-- Structure de la table `historique_note`
--

CREATE TABLE `historique_note` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `valeur_note` double NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `note` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `destinataire` varchar(255) DEFAULT NULL,
  `emetteur` varchar(255) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `module`
--

CREATE TABLE `module` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `code_module` varchar(255) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `module`
--

INSERT INTO `module` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `code_module`, `createur`, `modificateur`) VALUES
(12, '2022-04-01 18:31:13', '2022-04-02 18:31:13', 'Destine pour les licence1', 'techniques de calcul', 'destiner', 'ACTIVE', '12EM', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

CREATE TABLE `niveau` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `numero` int(11) DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `numero`, `createur`, `modificateur`) VALUES
(0, '2022-02-03 15:11:17', '2022-02-10 15:05:09', 'rosedd', 'hth', 'hhhh', 'ATTENTE', 1, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE `note` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `numero_table` int(11) DEFAULT NULL,
  `valeur_note` double NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `est_inscrit` bigint(20) DEFAULT NULL,
  `evaluation` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `notecc`
--

CREATE TABLE `notecc` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `valeur_note` double NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `candidat` bigint(20) NOT NULL,
  `type_note_cc` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `semestre`
--

CREATE TABLE `semestre` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `date_cloture` datetime DEFAULT NULL,
  `date_debut` datetime DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `annee_academique` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `semestre`
--

INSERT INTO `semestre` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `date_cloture`, `date_debut`, `createur`, `modificateur`, `annee_academique`) VALUES
(15, '2022-04-08 18:44:47', '2022-04-09 18:44:47', 'très capital', 'semestre1', 'houssein', 'ACTIVE', '2022-04-22 18:44:47', '2022-04-19 18:44:47', 0, 0, 16);

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

CREATE TABLE `session` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `date_connection` datetime DEFAULT NULL,
  `date_deconnection` datetime DEFAULT NULL,
  `machine_cliente` varchar(255) DEFAULT NULL,
  `statut` varchar(255) NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `utilisateur` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `sms`
--

CREATE TABLE `sms` (
  `code` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `specialite`
--

CREATE TABLE `specialite` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `filiere` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `specialite`
--

INSERT INTO `specialite` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `createur`, `modificateur`, `filiere`) VALUES
(0, '2022-02-03 15:15:11', '2022-02-10 15:15:11', 'tresbien', 'hh', 'hhh', 'ATTENTE', 0, 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `typenotecc`
--

CREATE TABLE `typenotecc` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `numero_cc` int(11) NOT NULL,
  `pourcentage_cc` int(11) NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `enseignement` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `type_evaluation`
--

CREATE TABLE `type_evaluation` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `pourcentage` float DEFAULT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `enseignement` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `type_evaluation`
--

INSERT INTO `type_evaluation` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `pourcentage`, `createur`, `modificateur`, `enseignement`) VALUES
(9, '2022-04-12 18:51:57', '2022-04-16 18:51:57', 'Formation professionnelle', 'SN', 'hassan', 'ACTIVE', 34, 0, 0, 14);

-- --------------------------------------------------------

--
-- Structure de la table `ue`
--

CREATE TABLE `ue` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `code_ue` varchar(255) DEFAULT NULL,
  `credits` double DEFAULT NULL,
  `statut` varchar(255) NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL,
  `module` bigint(20) DEFAULT NULL,
  `niveau` bigint(20) DEFAULT NULL,
  `specialite` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `ue`
--

INSERT INTO `ue` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `code_ue`, `credits`, `statut`, `createur`, `modificateur`, `module`, `niveau`, `specialite`) VALUES
(13, '2022-04-03 18:37:50', '2022-04-04 18:37:50', 'teste', 'java', 'hassan', 'ACTIVE', 'java302', 4, 'ACTIVE', 0, 0, 12, 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `code` bigint(20) NOT NULL,
  `date_creation` datetime NOT NULL,
  `date_modification` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `statut_vie` varchar(255) NOT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) NOT NULL,
  `statut` varchar(255) NOT NULL,
  `telephone` varchar(13) DEFAULT NULL,
  `login` varchar(255) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  `createur` bigint(20) NOT NULL,
  `modificateur` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`code`, `date_creation`, `date_modification`, `description`, `libelle`, `signature`, `statut_vie`, `date_naissance`, `email`, `nom`, `prenom`, `sexe`, `statut`, `telephone`, `login`, `mot_de_passe`, `createur`, `modificateur`) VALUES
(0, '2022-02-01 14:45:54', '2022-02-02 14:45:54', 'bon', 'bien', 'hassan', 'ATTENTE', '2022-02-03 14:45:54', 'hassan@gmail.com', 'fouapon', 'hassan', 'MASCULIN', 'ACTIVE', '698227743', 'hassanfouapon', 'has123', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur_roles`
--

CREATE TABLE `utilisateur_roles` (
  `code_utilisateur` bigint(20) NOT NULL,
  `code_role` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `annee_academique`
--
ALTER TABLE `annee_academique`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_swqgx3p4a54nx9d5jcbbneu74` (`signature`),
  ADD UNIQUE KEY `UK_jqa4m3yuqd3ima4er9ekfhfng` (`date_debut`),
  ADD KEY `FKtqlf20e4qf8ny1hhsiyhqya2` (`createur`),
  ADD KEY `FK9g8gq4q2l69gmbl2tharmi1yp` (`modificateur`);

--
-- Index pour la table `anonymat`
--
ALTER TABLE `anonymat`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UKqflnolv6obmqu47eqhuxyru8a` (`est_inscrit`,`evaluation`),
  ADD UNIQUE KEY `UK_55a4i09wfumlnog9a4kj8ufww` (`signature`),
  ADD KEY `FKoqtavm5egvnjbtp4dln1e1mk7` (`createur`),
  ADD KEY `FK26hvdd7v6gvgvji1pfqiqgujk` (`modificateur`),
  ADD KEY `FK22e311hjwk5cgh5tc4enr2lhp` (`evaluation`),
  ADD KEY `FK825cra02ih3j4x6q93rau3j9g` (`note`);

--
-- Index pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_kp7fp5gge2qfbd7o3oh7wycll` (`signature`),
  ADD KEY `FKrgohgr53dt6qf7fhpxbw8dgpo` (`createur`),
  ADD KEY `FKmj9y2pvoyknxto7ugfqfag5nh` (`modificateur`),
  ADD KEY `FKckmqib4w3f07136wt7mkuj11u` (`classe`);

--
-- Index pour la table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK24ihvdhfsc0penqk6ekck742b` (`niveau`,`specialite`),
  ADD UNIQUE KEY `UK_lrmrqvh45diosw3hf0lsglik7` (`signature`),
  ADD KEY `FKtv9myr4ovctpegm1y4dibwgi` (`createur`),
  ADD KEY `FKogr8upv8d1fua8fp4kbseol0q` (`modificateur`),
  ADD KEY `FK4unvyc4qj6a9scpch68qtm1xj` (`specialite`);

--
-- Index pour la table `discipline`
--
ALTER TABLE `discipline`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UKd4ux1e0woobmpqvg9e8ayr88s` (`etudiant`,`semestre`),
  ADD UNIQUE KEY `UK_g9p019ftpe4r66o1xh6ra6878` (`signature`),
  ADD KEY `FKl3h1nlgxbeh4g84dpilexmt5v` (`createur`),
  ADD KEY `FK17qqlm99pftl9j3njyvu481lr` (`modificateur`),
  ADD KEY `FKcdu9wb0xujcwfnxygmc49jyaf` (`semestre`);

--
-- Index pour la table `droit`
--
ALTER TABLE `droit`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_jf9o4fnv64ohva4e71l1str2o` (`signature`),
  ADD KEY `FKn6yo8tnj2a4afsdff9hk2cn5h` (`createur`),
  ADD KEY `FKkf9dueb82ejssjaswb9xl0lst` (`modificateur`),
  ADD KEY `FKr2yr2w50usmy2ahoy8d76aiqn` (`role`);

--
-- Index pour la table `email`
--
ALTER TABLE `email`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_f2cktgex39i7stskdkw31856r` (`signature`),
  ADD KEY `FK62mp9usc5mpg20n76kspspgvx` (`createur`),
  ADD KEY `FKen5dl1lyix01ct0d07xt6pk08` (`modificateur`);

--
-- Index pour la table `enseignement`
--
ALTER TABLE `enseignement`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UKngaxph8cbvyptq9dfjcjiscj` (`semestre`,`ue`),
  ADD UNIQUE KEY `UK_ta6o1wub888wcgwu6tvoxtjl1` (`signature`),
  ADD KEY `FKetpfil0gxuk4vckvjtbw79c1` (`createur`),
  ADD KEY `FKgv8kb5o37nuh6piln511060rt` (`modificateur`),
  ADD KEY `FKjwbx5yto58u1rm2aqgfnnroy2` (`ue`);

--
-- Index pour la table `enseignement_enseignants`
--
ALTER TABLE `enseignement_enseignants`
  ADD KEY `FK201p4d11rmthcrqw1k4shoim0` (`code_enseignant`),
  ADD KEY `FKf40ksyje7jlfp0w9m2hf99gg5` (`code_enseignement`);

--
-- Index pour la table `envoi_message`
--
ALTER TABLE `envoi_message`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_otqfnp08pi4qlsxhv5s338rpc` (`signature`),
  ADD KEY `FKrcdke2i44nbh4fevhlt4l5d66` (`createur`),
  ADD KEY `FKlhj2g1aicpu3fuuy9k6rngmne` (`modificateur`),
  ADD KEY `FK43c4koyv0sn9s3272uyha1p1m` (`candidat`),
  ADD KEY `FK1kv3hlebkvcv22kn3je54pxp` (`message`);

--
-- Index pour la table `est_inscrit`
--
ALTER TABLE `est_inscrit`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UKndwj6ffdss2uatcsni75jg4ve` (`candidat_inscrit`,`enseignement`),
  ADD UNIQUE KEY `UK_kq2g8hmerotw5a5j57gn0cj07` (`signature`),
  ADD KEY `FKtmj6w0h3iiaoerilf61n1q60v` (`createur`),
  ADD KEY `FK3ch6wfew01th4uelfakja3to8` (`modificateur`),
  ADD KEY `FK76qj5pwceuji71u8fm3bsqr2v` (`enseignement`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_11cw6xkucs8gpuyq1lwnk8jk1` (`code_authentification`),
  ADD UNIQUE KEY `UK_tn2q9dbx4m888c3xgvxt7bt58` (`matricule`);

--
-- Index pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_95d13va0jy58insg1huj14f6e` (`signature`),
  ADD UNIQUE KEY `UK_1rifn6uii9w84haw6ljuisad0` (`type_evaluation`),
  ADD KEY `FKf7oy1x1luiy26t3fjuaivq44q` (`createur`),
  ADD KEY `FKjte9pklvx47lxe632e4g57269` (`modificateur`);

--
-- Index pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_teswpig4cif4hbcky3bscixko` (`signature`),
  ADD KEY `FKhsabmfq0809u71n6ery8ewrx9` (`createur`),
  ADD KEY `FKqeiw7korq0vpfkxtye0ggg6n3` (`modificateur`);

--
-- Index pour la table `historique_note`
--
ALTER TABLE `historique_note`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_17bin07m3uk0qy9or6rc82tux` (`signature`),
  ADD KEY `FK6jtfsfgcocothg8jhpabvd48q` (`createur`),
  ADD KEY `FKmxxbf2hs95xk8lri3jm0p02jn` (`modificateur`),
  ADD KEY `FKnhoos8op2nbq8pojghlqjv56i` (`note`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_c4369qvafpbdi0ihuw5n2bf7p` (`signature`),
  ADD KEY `FKhwyy1g38dt18440657edhs5sa` (`createur`),
  ADD KEY `FKboeogt6mhbnhl2i3dy7c7jwcj` (`modificateur`);

--
-- Index pour la table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_o5eivr3ymhq5d27r1k6psqtmb` (`signature`),
  ADD UNIQUE KEY `UK_t085aljqp479ff31f5ky4spf2` (`code_module`),
  ADD KEY `FKnuo31jdyq18hq0chu6gii3jay` (`createur`),
  ADD KEY `FK6loujm8dbo02rw2uq22ogibjn` (`modificateur`);

--
-- Index pour la table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_se5yc80tmgst8uam2cwum86wx` (`signature`),
  ADD KEY `FK5dqggj8l3tdm0qcspbilhw0rq` (`createur`),
  ADD KEY `FKkw6ldawvna2dnc19v1811ku8o` (`modificateur`);

--
-- Index pour la table `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UKkbvh99q5yy8raek6yg1r0bxst` (`est_inscrit`,`evaluation`),
  ADD UNIQUE KEY `UK_72mob866s0dnvmx4beyguiehq` (`signature`),
  ADD KEY `FKy5jg1dfflruxxvvlyutsg4nn` (`createur`),
  ADD KEY `FKefvwu13yxpdutn98iq80k3iut` (`modificateur`),
  ADD KEY `FK1c72scifonby8tkpkq72miyxl` (`evaluation`);

--
-- Index pour la table `notecc`
--
ALTER TABLE `notecc`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK89yc811nft5iuf03lejj44fb5` (`candidat`,`type_note_cc`),
  ADD UNIQUE KEY `UK_9evtp4i4qres6s2bbjil8x8ig` (`signature`),
  ADD KEY `FKnr07if5ftcxs0htjom440l6nn` (`createur`),
  ADD KEY `FK1uw1vi8qlyy0v0v73l9w19ayp` (`modificateur`),
  ADD KEY `FK99d9sfb61ut58etbjehea0o5o` (`type_note_cc`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_meqij2822vi8y8mu35yx9sjnr` (`signature`),
  ADD KEY `FKca9lualoqf8l6101hfsx5n21y` (`createur`),
  ADD KEY `FKhqto4e85monmwdtrfibso2m0f` (`modificateur`);

--
-- Index pour la table `semestre`
--
ALTER TABLE `semestre`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UKtjmxo0xbj2p5dbuskkgl72skp` (`annee_academique`,`date_debut`),
  ADD UNIQUE KEY `UK_t36vxsujsk69ae5qr9ds2m0y0` (`signature`),
  ADD KEY `FKpu11ys4d55iw460llrvfki7fi` (`createur`),
  ADD KEY `FKbhrovx061g829el4bxpomucgs` (`modificateur`);

--
-- Index pour la table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_j6pdf9e8niastiyjthxc7v2le` (`signature`),
  ADD KEY `FKri27qya8fw3ampk2wk20vhqhw` (`createur`),
  ADD KEY `FK6620hcfbf2ekskpbggoeghv8q` (`modificateur`),
  ADD KEY `FKpd70fxo08v66nw7mpj4erpw1y` (`utilisateur`);

--
-- Index pour la table `sms`
--
ALTER TABLE `sms`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `specialite`
--
ALTER TABLE `specialite`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK9io72yj9jor9fna2duk8m11i3` (`filiere`,`libelle`),
  ADD UNIQUE KEY `UK_exeroh98uteryvp4aqimmnbxf` (`signature`),
  ADD KEY `FKpt3xwgejlnwulufwdiite4s8q` (`createur`),
  ADD KEY `FKfwjj8al7o0x1kh62v8yukwdme` (`modificateur`);

--
-- Index pour la table `typenotecc`
--
ALTER TABLE `typenotecc`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK1jnwwq6e59vhwv1hceg4ekq4j` (`numero_cc`,`enseignement`),
  ADD UNIQUE KEY `UK_htvtot1orn6p968oa4ncn3mmp` (`signature`),
  ADD KEY `FK5odob9ccwlknvnfy5sbqwk3nc` (`createur`),
  ADD KEY `FKgqhtj1d1sl57hbib2ykoc2guj` (`modificateur`),
  ADD KEY `FKoe20yrihyxiywpn5wo7hwq9ga` (`enseignement`);

--
-- Index pour la table `type_evaluation`
--
ALTER TABLE `type_evaluation`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_a3nl56a846n5twg1sjd72f9ip` (`signature`),
  ADD KEY `FKltv1xvi6lmfr48wgixkkyd80u` (`createur`),
  ADD KEY `FK8i7sidthkt77n2iborl637bay` (`modificateur`),
  ADD KEY `FK8hvpa659w0s7dxxpsykqfkh3t` (`enseignement`);

--
-- Index pour la table `ue`
--
ALTER TABLE `ue`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_fd4vwpoclkj79gup883k5322r` (`signature`),
  ADD UNIQUE KEY `UK_coy6lcouaqcjv0qjl5wcrqhc1` (`code_ue`),
  ADD KEY `FK41yoptwlgewuh2je0ea5htdj6` (`createur`),
  ADD KEY `FKnylp4kyr810b8qx2n1msl0x9p` (`modificateur`),
  ADD KEY `FK84eqmm0xb2agn4y7dlue7e4up` (`module`),
  ADD KEY `FKtpcju8pqbenklq3oie8k3h07n` (`niveau`),
  ADD KEY `FKbafyoc30fd7drcocax8jmx27q` (`specialite`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `UK_18vwp4resqussqmlpqnymfqxk` (`login`),
  ADD UNIQUE KEY `UK_r2pd0ycq6b84ovdvxq7hp82cx` (`signature`),
  ADD KEY `FK2mjmr794svc287xjcid05c1tw` (`createur`),
  ADD KEY `FK3k2w81chxx9yff39c0rtmebc8` (`modificateur`);

--
-- Index pour la table `utilisateur_roles`
--
ALTER TABLE `utilisateur_roles`
  ADD KEY `FKqb7gow4lc2dkt10d7umghase8` (`code_role`),
  ADD KEY `FKjdfk58cmwvdyffgd1k96xj1hd` (`code_utilisateur`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `annee_academique`
--
ALTER TABLE `annee_academique`
  ADD CONSTRAINT `FK9g8gq4q2l69gmbl2tharmi1yp` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKtqlf20e4qf8ny1hhsiyhqya2` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `anonymat`
--
ALTER TABLE `anonymat`
  ADD CONSTRAINT `FK176x70m5notn2739ywadbdrje` FOREIGN KEY (`est_inscrit`) REFERENCES `est_inscrit` (`code`),
  ADD CONSTRAINT `FK22e311hjwk5cgh5tc4enr2lhp` FOREIGN KEY (`evaluation`) REFERENCES `evaluation` (`code`),
  ADD CONSTRAINT `FK26hvdd7v6gvgvji1pfqiqgujk` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FK825cra02ih3j4x6q93rau3j9g` FOREIGN KEY (`note`) REFERENCES `note` (`code`),
  ADD CONSTRAINT `FKoqtavm5egvnjbtp4dln1e1mk7` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `candidat`
--
ALTER TABLE `candidat`
  ADD CONSTRAINT `FKckmqib4w3f07136wt7mkuj11u` FOREIGN KEY (`classe`) REFERENCES `classe` (`code`),
  ADD CONSTRAINT `FKmj9y2pvoyknxto7ugfqfag5nh` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKrgohgr53dt6qf7fhpxbw8dgpo` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `FK4unvyc4qj6a9scpch68qtm1xj` FOREIGN KEY (`specialite`) REFERENCES `specialite` (`code`),
  ADD CONSTRAINT `FK8gf9pulyu8yxnaao3lj8wvomb` FOREIGN KEY (`niveau`) REFERENCES `niveau` (`code`),
  ADD CONSTRAINT `FKogr8upv8d1fua8fp4kbseol0q` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKtv9myr4ovctpegm1y4dibwgi` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `discipline`
--
ALTER TABLE `discipline`
  ADD CONSTRAINT `FK17qqlm99pftl9j3njyvu481lr` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKcdu9wb0xujcwfnxygmc49jyaf` FOREIGN KEY (`semestre`) REFERENCES `semestre` (`code`),
  ADD CONSTRAINT `FKl3h1nlgxbeh4g84dpilexmt5v` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKrg1sqsw82ui0jyhnn1joveyvx` FOREIGN KEY (`etudiant`) REFERENCES `etudiant` (`code`);

--
-- Contraintes pour la table `droit`
--
ALTER TABLE `droit`
  ADD CONSTRAINT `FKkf9dueb82ejssjaswb9xl0lst` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKn6yo8tnj2a4afsdff9hk2cn5h` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKr2yr2w50usmy2ahoy8d76aiqn` FOREIGN KEY (`role`) REFERENCES `role` (`code`);

--
-- Contraintes pour la table `email`
--
ALTER TABLE `email`
  ADD CONSTRAINT `FK8wtck3hd2hbmancm9hu293965` FOREIGN KEY (`code`) REFERENCES `message` (`code`);

--
-- Contraintes pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD CONSTRAINT `FK62mp9usc5mpg20n76kspspgvx` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKen5dl1lyix01ct0d07xt6pk08` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `enseignement`
--
ALTER TABLE `enseignement`
  ADD CONSTRAINT `FKetpfil0gxuk4vckvjtbw79c1` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKgv8kb5o37nuh6piln511060rt` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKjwbx5yto58u1rm2aqgfnnroy2` FOREIGN KEY (`ue`) REFERENCES `ue` (`code`),
  ADD CONSTRAINT `FKqodhl3spy5a992m1q7lplot6k` FOREIGN KEY (`semestre`) REFERENCES `semestre` (`code`);

--
-- Contraintes pour la table `enseignement_enseignants`
--
ALTER TABLE `enseignement_enseignants`
  ADD CONSTRAINT `FK201p4d11rmthcrqw1k4shoim0` FOREIGN KEY (`code_enseignant`) REFERENCES `enseignant` (`code`),
  ADD CONSTRAINT `FKf40ksyje7jlfp0w9m2hf99gg5` FOREIGN KEY (`code_enseignement`) REFERENCES `enseignement` (`code`);

--
-- Contraintes pour la table `envoi_message`
--
ALTER TABLE `envoi_message`
  ADD CONSTRAINT `FK1kv3hlebkvcv22kn3je54pxp` FOREIGN KEY (`message`) REFERENCES `message` (`code`),
  ADD CONSTRAINT `FK43c4koyv0sn9s3272uyha1p1m` FOREIGN KEY (`candidat`) REFERENCES `candidat` (`code`),
  ADD CONSTRAINT `FKlhj2g1aicpu3fuuy9k6rngmne` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKrcdke2i44nbh4fevhlt4l5d66` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `est_inscrit`
--
ALTER TABLE `est_inscrit`
  ADD CONSTRAINT `FK3ch6wfew01th4uelfakja3to8` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FK76qj5pwceuji71u8fm3bsqr2v` FOREIGN KEY (`enseignement`) REFERENCES `enseignement` (`code`),
  ADD CONSTRAINT `FK8vmwig2cb5gg5o7rk1wltj43o` FOREIGN KEY (`candidat_inscrit`) REFERENCES `candidat` (`code`),
  ADD CONSTRAINT `FKtmj6w0h3iiaoerilf61n1q60v` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `FK8gcsdncsoaccdridlem7078t9` FOREIGN KEY (`code`) REFERENCES `candidat` (`code`);

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `FKf7oy1x1luiy26t3fjuaivq44q` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKhdgpb3w5ouu8ci32evrjvjn8n` FOREIGN KEY (`type_evaluation`) REFERENCES `type_evaluation` (`code`),
  ADD CONSTRAINT `FKjte9pklvx47lxe632e4g57269` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `filiere`
--
ALTER TABLE `filiere`
  ADD CONSTRAINT `FKhsabmfq0809u71n6ery8ewrx9` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKqeiw7korq0vpfkxtye0ggg6n3` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `historique_note`
--
ALTER TABLE `historique_note`
  ADD CONSTRAINT `FK6jtfsfgcocothg8jhpabvd48q` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKmxxbf2hs95xk8lri3jm0p02jn` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKnhoos8op2nbq8pojghlqjv56i` FOREIGN KEY (`note`) REFERENCES `note` (`code`);

--
-- Contraintes pour la table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `FKboeogt6mhbnhl2i3dy7c7jwcj` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKhwyy1g38dt18440657edhs5sa` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `FK6loujm8dbo02rw2uq22ogibjn` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKnuo31jdyq18hq0chu6gii3jay` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `niveau`
--
ALTER TABLE `niveau`
  ADD CONSTRAINT `FK5dqggj8l3tdm0qcspbilhw0rq` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKkw6ldawvna2dnc19v1811ku8o` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `note`
--
ALTER TABLE `note`
  ADD CONSTRAINT `FK1c72scifonby8tkpkq72miyxl` FOREIGN KEY (`evaluation`) REFERENCES `evaluation` (`code`),
  ADD CONSTRAINT `FKefvwu13yxpdutn98iq80k3iut` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKkxolhkghss1hp264kqev1wviy` FOREIGN KEY (`est_inscrit`) REFERENCES `est_inscrit` (`code`),
  ADD CONSTRAINT `FKy5jg1dfflruxxvvlyutsg4nn` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `notecc`
--
ALTER TABLE `notecc`
  ADD CONSTRAINT `FK1uw1vi8qlyy0v0v73l9w19ayp` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FK99d9sfb61ut58etbjehea0o5o` FOREIGN KEY (`type_note_cc`) REFERENCES `typenotecc` (`code`),
  ADD CONSTRAINT `FKmmfofggt5p4p1gk8ll3wyj2ap` FOREIGN KEY (`candidat`) REFERENCES `candidat` (`code`),
  ADD CONSTRAINT `FKnr07if5ftcxs0htjom440l6nn` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `role`
--
ALTER TABLE `role`
  ADD CONSTRAINT `FKca9lualoqf8l6101hfsx5n21y` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKhqto4e85monmwdtrfibso2m0f` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `semestre`
--
ALTER TABLE `semestre`
  ADD CONSTRAINT `FKbhrovx061g829el4bxpomucgs` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKn7kb6cfu4lhv0iwcyflpq3wj5` FOREIGN KEY (`annee_academique`) REFERENCES `annee_academique` (`code`),
  ADD CONSTRAINT `FKpu11ys4d55iw460llrvfki7fi` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `FK6620hcfbf2ekskpbggoeghv8q` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKpd70fxo08v66nw7mpj4erpw1y` FOREIGN KEY (`utilisateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKri27qya8fw3ampk2wk20vhqhw` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `sms`
--
ALTER TABLE `sms`
  ADD CONSTRAINT `FKfvwkvb1ti5ecpxle41b1b99ad` FOREIGN KEY (`code`) REFERENCES `message` (`code`);

--
-- Contraintes pour la table `specialite`
--
ALTER TABLE `specialite`
  ADD CONSTRAINT `FKfwjj8al7o0x1kh62v8yukwdme` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKpt3xwgejlnwulufwdiite4s8q` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKs4km7op1ph6dstp70uommmnmy` FOREIGN KEY (`filiere`) REFERENCES `filiere` (`code`);

--
-- Contraintes pour la table `typenotecc`
--
ALTER TABLE `typenotecc`
  ADD CONSTRAINT `FK5odob9ccwlknvnfy5sbqwk3nc` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKgqhtj1d1sl57hbib2ykoc2guj` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKoe20yrihyxiywpn5wo7hwq9ga` FOREIGN KEY (`enseignement`) REFERENCES `enseignement` (`code`);

--
-- Contraintes pour la table `type_evaluation`
--
ALTER TABLE `type_evaluation`
  ADD CONSTRAINT `FK8hvpa659w0s7dxxpsykqfkh3t` FOREIGN KEY (`enseignement`) REFERENCES `enseignement` (`code`),
  ADD CONSTRAINT `FK8i7sidthkt77n2iborl637bay` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKltv1xvi6lmfr48wgixkkyd80u` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `ue`
--
ALTER TABLE `ue`
  ADD CONSTRAINT `FK41yoptwlgewuh2je0ea5htdj6` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FK84eqmm0xb2agn4y7dlue7e4up` FOREIGN KEY (`module`) REFERENCES `module` (`code`),
  ADD CONSTRAINT `FKbafyoc30fd7drcocax8jmx27q` FOREIGN KEY (`specialite`) REFERENCES `specialite` (`code`),
  ADD CONSTRAINT `FKnylp4kyr810b8qx2n1msl0x9p` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKtpcju8pqbenklq3oie8k3h07n` FOREIGN KEY (`niveau`) REFERENCES `niveau` (`code`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK2mjmr794svc287xjcid05c1tw` FOREIGN KEY (`createur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FK3k2w81chxx9yff39c0rtmebc8` FOREIGN KEY (`modificateur`) REFERENCES `utilisateur` (`code`);

--
-- Contraintes pour la table `utilisateur_roles`
--
ALTER TABLE `utilisateur_roles`
  ADD CONSTRAINT `FKjdfk58cmwvdyffgd1k96xj1hd` FOREIGN KEY (`code_utilisateur`) REFERENCES `utilisateur` (`code`),
  ADD CONSTRAINT `FKqb7gow4lc2dkt10d7umghase8` FOREIGN KEY (`code_role`) REFERENCES `role` (`code`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
