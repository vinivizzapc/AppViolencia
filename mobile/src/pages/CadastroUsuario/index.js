import React from 'react';
import { useNavigation } from '@react-navigation/native';
import { View, Text } from 'react-native';

import styles from './style';

export default function CadastroUsuario() {
    const navigation = useNavigation();

    return (
        <View>
            <Text>Cadastro de Usuario</Text>
        </View>
    );
}