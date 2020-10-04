import React from 'react';
import { createStackNavigator } from '@react-navigation/stack';
import { NavigationContainer } from '@react-navigation/native';

import CadastroUsuario from './pages/CadastroUsuario';
import Login from './pages/Login';

const Stack = createStackNavigator();

export default function Routes() {
    return (
        <NavigationContainer>
            <Stack.Navigator screenOptions={{ headerShown: false }}>
                <Stack.Screen name="Login" component={Login} />
                <Stack.Screen name="CadastroUsuario" component={CadastroUsuario} />
            </Stack.Navigator>
        </NavigationContainer>
    );
}