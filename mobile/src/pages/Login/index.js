import React from 'react';
import { View, Text } from 'react-native';
import { useNavigation } from '@react-navigation/native';

import styles from './style';
import { TouchableOpacity } from 'react-native-gesture-handler';

export default function Login() {
    const navigation = useNavigation();

    function navigateToCadastro(){
        navigation.navigate('CadastroUsuario');
    }

    return (
        <View>
            <Text>Login</Text>
            <TouchableOpacity onPress={() => navigateToCadastro()}>
                <Text>Cadastra-se</Text>
            </TouchableOpacity>
        </View>
    );
}