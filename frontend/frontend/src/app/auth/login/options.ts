export const loginPageOptions = {
  title: 'College Portal Login',
  buttonText: 'Login',
  fields: [
    {
      key: 'username',
      label: 'Username',
      type: 'text',
      placeholder: 'Enter username'
    },
    {
      key: 'password',
      label: 'Password',
      type: 'password',
      placeholder: 'Enter password'
    }
  ],
  roles: [
    { value: 'STUDENT', label: 'Student' },
    { value: 'FACULTY_MEMBER', label: 'Faculty' },
    { value: 'ADMINISTRATOR', label: 'Administrator' }
  ]
};